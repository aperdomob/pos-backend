package syoux.apps.pos.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import syoux.apps.pos.controllers.exceptions.ProductNotFoundException;
import syoux.apps.pos.domain.ProductDomain;
import syoux.apps.pos.domain.StocktakingDomain;
import syoux.apps.pos.repository.ProductRepository;
import syoux.apps.pos.repository.StocktakingRepository;
import syoux.apps.pos.repository.entity.Product;
import syoux.apps.pos.repository.entity.Stocktaking;
import syoux.apps.pos.services.interfaces.IProductService;
import syoux.apps.pos.services.mapper.ProductMapper;
import syoux.apps.pos.services.mapper.StocktakingMapper;

@Service
public class ProductService implements IProductService {
  @Autowired
  ProductRepository productRepository;

  @Autowired
  StocktakingRepository stocktakingRepository;

  @Autowired
  ProductMapper productMapper;

  @Autowired
  StocktakingMapper stocktakingMapper;

  @Override
  public ProductDomain create(ProductDomain product) {
    Product productEntity = this.productRepository.save(this.productMapper.domainToEntity(product));
    Stocktaking stocktakingEntity = new Stocktaking(productEntity);

    if ( product.getStocktaking().size() != 0) {
      stocktakingEntity.setAvailable(product.getStocktaking().get(0).getAvailable());
      stocktakingEntity.setLastCost(product.getStocktaking().get(0).getLastCost());
    }

    StocktakingDomain stocktaking = stocktakingMapper.entityToDomain(this.stocktakingRepository.save(stocktakingEntity));

    ProductDomain newProduct = productMapper.entityToDomain(productEntity);
    newProduct.getStocktaking().add(stocktaking);

    return newProduct;
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

  @Override
  public void createOrUpdate(List<ProductDomain> products) {
    for (ProductDomain product : products) {
      Product db = this.productRepository.findByReference(product.getReference()).orElse(null);

      if (db == null) {
        this.create(product);
      } else {
        product.setId(db.getId());

        this.update(product);
      }

    }
  }
}
