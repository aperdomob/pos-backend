package syoux.apps.pos.controllers.endpoints.stocktaking;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import syoux.apps.pos.domain.ProductDomain;
import syoux.apps.pos.services.ProductService;
import syoux.apps.pos.services.interfaces.IExcelService;

@RestController()
@RequestMapping("/stock")
public class StocktakingController {
  @Autowired
  private IExcelService excelService;

  @Autowired
  ProductService productService;

  @PostMapping(path = "/load", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public void Load(@RequestPart(value = "file", required = true) MultipartFile file)
      throws IOException {
    List<ProductDomain>  products = this.excelService.extract(file.getInputStream());

    productService.createOrUpdate(products);
  }
}
