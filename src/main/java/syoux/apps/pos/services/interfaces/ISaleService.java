package syoux.apps.pos.services.interfaces;

import java.util.List;
import syoux.apps.pos.repository.entity.Sale;
import syoux.apps.pos.repository.entity.SaleItem;

public interface ISaleService {

  List<Sale> getAllSales();
  Sale one(Long id);

  Sale create();
  void addItem(Long id, SaleItem item);


  List<SaleItem> getAllItems();
}
