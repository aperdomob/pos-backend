package syoux.apps.pos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import syoux.apps.pos.repository.entity.Product;
import syoux.apps.pos.repository.entity.Stocktaking;

public interface StocktakingRepository extends JpaRepository<Stocktaking, Long> {

  List<Stocktaking> findByProduct(Product product);
}
