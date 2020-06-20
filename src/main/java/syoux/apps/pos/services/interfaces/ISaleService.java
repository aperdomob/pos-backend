package syoux.apps.pos.services.interfaces;

import java.util.Arrays;
import java.util.List;
import syoux.apps.pos.domain.SaleDomain;
import syoux.apps.pos.domain.SaleItemDomain;

public interface ISaleService {

  List<SaleDomain> getAllSales();
  SaleDomain one(Long id);

  SaleDomain create();
  SaleItemDomain addItem(Long id, SaleItemDomain item);


  List<SaleItemDomain> getAllItems();

  SaleItemDomain getItem(Long saleId, Long id);

  List<SaleItemDomain> getItems(Long saleId);
}
