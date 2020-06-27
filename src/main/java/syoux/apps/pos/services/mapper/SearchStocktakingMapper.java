package syoux.apps.pos.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import syoux.apps.pos.domain.ProductDomain;
import syoux.apps.pos.domain.SearchStocktakingDomain;
import syoux.apps.pos.domain.StocktakingDomain;
import syoux.apps.pos.repository.entity.Product;
import syoux.apps.pos.repository.entity.Stocktaking;

@Mapper(componentModel = "spring")
public abstract class SearchStocktakingMapper {
  public SearchStocktakingDomain map(Stocktaking entity) {
    SearchStocktakingDomain domain = new SearchStocktakingDomain();
    domain.setProduct(mapToProduct(entity));
    domain.setStocktaking(mapToStocktaking(entity));

    return domain;
  }

  public abstract StocktakingDomain mapToStocktaking(Stocktaking entity);

  public ProductDomain mapToProduct(Stocktaking entity) {
    return this.mapToProduct(entity.getProduct());
  }

  @Mapping(target = "stocktaking", ignore = true)
  public abstract ProductDomain mapToProduct(Product entity);
}
