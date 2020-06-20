package syoux.apps.pos.services.interfaces;

import syoux.apps.pos.domain.ProductDomain;

public interface IProductService {
  ProductDomain create(ProductDomain product);
}
