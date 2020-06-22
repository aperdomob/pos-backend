package syoux.apps.pos.controllers.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import syoux.apps.pos.controllers.dto.ProductDto;
import syoux.apps.pos.controllers.dto.SaleDto;
import syoux.apps.pos.controllers.dto.StocktakingDto;
import syoux.apps.pos.domain.ProductDomain;
import syoux.apps.pos.domain.SaleDomain;
import syoux.apps.pos.domain.StocktakingDomain;

@Mapper(componentModel = "spring")
public abstract class ProductDtoMapper {
  public abstract ProductDomain map(ProductDto dto);

  public abstract ProductDto map(ProductDomain product);

  @Mapping(target = "productId", ignore = true)
  public abstract StocktakingDto map(StocktakingDomain domain);

  @AfterMapping
  protected void setProductId(@MappingTarget ProductDto product) {
    product.getStocktaking().forEach(stocktaking -> {
      stocktaking.setProductId(product.getId());
    });
  }
}
