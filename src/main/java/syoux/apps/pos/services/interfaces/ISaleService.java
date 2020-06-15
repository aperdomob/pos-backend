package syoux.apps.pos.services.interfaces;

import java.util.List;
import java.util.Optional;
import syoux.apps.pos.repository.entity.Sale;

public interface ISaleService {

  Sale create();

  List<Sale> getAllSales();

  Optional<Sale> one(Long id);
}
