package syoux.apps.pos.services.interfaces;

import java.util.List;
import syoux.apps.pos.domain.SaleDomain;
import syoux.apps.pos.domain.SaleItemDomain;
import syoux.apps.pos.repository.entity.Sale;
import syoux.apps.pos.repository.entity.SaleItem;

public interface ISaleService {

  List<SaleDomain> getAllSales();
  SaleDomain one(Long id);

  SaleDomain create();
  void addItem(Long id, SaleItemDomain item);


  List<SaleItemDomain> getAllItems();
}
