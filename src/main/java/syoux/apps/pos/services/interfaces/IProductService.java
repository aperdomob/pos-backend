package syoux.apps.pos.services.interfaces;

import java.util.List;
import syoux.apps.pos.domain.ProductDomain;

public interface IProductService {
  ProductDomain create(ProductDomain product);

  List<ProductDomain> all();

  ProductDomain update(ProductDomain product);

  void delete(Long productId);
}
