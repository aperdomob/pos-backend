package syoux.apps.pos.services;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.springframework.stereotype.Service;
import syoux.apps.pos.domain.ProductDomain;
import syoux.apps.pos.domain.StocktakingDomain;
import syoux.apps.pos.services.interfaces.IExcelService;

@Service
public class ExcelService implements IExcelService {

  @Override
  public List<ProductDomain> extract(InputStream excel) {
    try {
      Workbook workbook = WorkbookFactory.create(excel);
      Sheet sheet = workbook.getSheetAt(0);

      return extractProducts(sheet);
    } catch (Exception ex) {
      return Collections.emptyList();
    }
  }

  private List<ProductDomain> extractProducts(Sheet sheet) {
    int lastRow = getLastRow(sheet);
    List<ProductDomain> products = new ArrayList<>();

    for (int row = 1; row <= lastRow; row++) {
      try {
        ProductDomain product = map(sheet.getRow(row));

        if (isValidProduct(product)) {
          products.add(product);
        }
      } catch (Exception ex) {
        System.out.println(ex);
      }

    }

    return products;
  }

  private boolean isValidProduct(ProductDomain product) {
    return product.getReference() != null
        && !product.getReference().isBlank()
        && product.getName() != null
        && !product.getName().isBlank();
  }

  private ProductDomain map(Row row) {
    ProductDomain product = new ProductDomain();

    product.setReference(getReferenceValue(row));
    product.setName(row.getCell(1).getStringCellValue());
    product.setPrice(row.getCell(4).getNumericCellValue());

    StocktakingDomain stocktaking = new StocktakingDomain();
    stocktaking.setAvailable((long) row.getCell(2).getNumericCellValue());
    stocktaking.setLastCost(row.getCell(3).getNumericCellValue());

    product.getStocktaking().add(stocktaking);

    return product;
  }

  private int getLastRow(Sheet sheet) {
    int currentPosition = 0;

    for (int row = 0; row < 65000; row++) {
      String value = sheet.getRow(row).getCell(1).getStringCellValue();

      if (value != null && !value.isBlank()) {
        currentPosition = row;
      }

      if (row - currentPosition > 10) {
        break;
      }
    }

    return currentPosition;
  }

  private Object getCellValue(Cell cell) {
    try {
      return cell.getStringCellValue();
    } catch (Exception ex) { }

    try {
      return cell.getNumericCellValue();
    } catch (Exception ex) {}

    return null;
  }

  private String getReferenceValue(Row row) {
    XSSFCell cell = (XSSFCell) row.getCell(0);

    return cell.getRawValue();
  }

//  private String convertCellValueToString(Cell cell) {
//    CellType cellType = cell.getCellType();
//
//    switch (cellType) {
//      case BLANK:
//        return "";
//      // case BOOLEAN:
//        // return TRUE_AS_STRING.equals(_cell.getV()) ? TRUE : FALSE;
//      case STRING:
//        int sstIndex = Integer.parseInt(_cell.getV());
//        XSSFRichTextString rt = new XSSFRichTextString(_sharedStringSource.getEntryAt(sstIndex));
//        return rt.getString();
//      case NUMERIC:
//      case ERROR:
//        return _cell.getV();
//      case FORMULA:
//        // should really evaluate, but HSSFCell can't call HSSFFormulaEvaluator
//        // just use cached formula result instead
//        break;
//      default:
//        throw new IllegalStateException("Unexpected cell type (" + cellType + ")");
//    }
//    cellType = getBaseCellType(false);
//    String textValue = _cell.getV();
//    switch (cellType) {
//      case BOOLEAN:
//        if (TRUE_AS_STRING.equals(textValue)) {
//          return TRUE;
//        }
//        if (FALSE_AS_STRING.equals(textValue)) {
//          return FALSE;
//        }
//        throw new IllegalStateException("Unexpected boolean cached formula value '"
//            + textValue + "'.");
//
//      case STRING:
//        // fall-through
//      case NUMERIC:
//        // fall-through
//      case ERROR:
//        return textValue;
//
//      default:
//        throw new IllegalStateException("Unexpected formula result type (" + cellType + ")");
//    }
//
//  }
}
