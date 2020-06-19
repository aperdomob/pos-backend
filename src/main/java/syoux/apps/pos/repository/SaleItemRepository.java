package syoux.apps.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syoux.apps.pos.repository.entity.SaleItem;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {

}
