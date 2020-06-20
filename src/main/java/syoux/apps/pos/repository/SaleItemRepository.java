package syoux.apps.pos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import syoux.apps.pos.repository.entity.Sale;
import syoux.apps.pos.repository.entity.SaleItem;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
  List<SaleItem> findBySale(Sale sale);
}
