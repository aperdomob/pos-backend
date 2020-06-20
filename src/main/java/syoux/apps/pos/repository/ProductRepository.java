package syoux.apps.pos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import syoux.apps.pos.repository.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByNameAndReferenceAllIgnoreCase(String name, String reference);
}
