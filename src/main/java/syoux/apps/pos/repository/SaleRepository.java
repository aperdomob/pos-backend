package syoux.apps.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syoux.apps.pos.repository.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
