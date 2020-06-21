package syoux.apps.pos.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import syoux.apps.pos.controllers.exceptions.ProductNotFoundException;
import syoux.apps.pos.domain.ProductDomain;
import syoux.apps.pos.repository.ProductRepository;
import syoux.apps.pos.repository.entity.Product;
import syoux.apps.pos.services.interfaces.IProductService;
import syoux.apps.pos.services.mapper.ProductMapper;

@Service
public class ProductService implements IProductService {
  @Autowired
  ProductRepository productRepository;

  @Autowired
  ProductMapper productMapper;

  @Override
  public ProductDomain create(ProductDomain product) {
    return productMapper.entityToDomain(this.productRepository.save(this.productMapper.domainToEntity(product)));
  }

  @Override
  public List<ProductDomain> all() {
    return this.productRepository
        .findAll()
        .stream()
        .map(productMapper::entityToDomain)
        .collect(Collectors.toList());
  }

  @Override
  public ProductDomain update(ProductDomain product) {
    this.productRepository
        .findById(product.getId())
        .orElseThrow(() -> new ProductNotFoundException(product.getId()));

    return this.productMapper
        .entityToDomain(this.productRepository.save(productMapper.domainToEntity(product)));
  }

  @Override
  public void delete(Long productId) {
    Product product = this.productRepository.findById(productId).orElse(null);

    if (product != null) {
      this.productRepository.delete(product);
    }
  }
}
