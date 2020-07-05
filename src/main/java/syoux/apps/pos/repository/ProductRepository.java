package syoux.apps.pos.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import syoux.apps.pos.repository.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByNameContainingOrReferenceContainingAllIgnoreCase(String name, String reference);
  Optional<Product> findByReference(String reference);
}
