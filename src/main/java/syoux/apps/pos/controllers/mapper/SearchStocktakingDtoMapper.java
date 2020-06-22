package syoux.apps.pos.controllers.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import syoux.apps.pos.controllers.dto.SearchStocktakingDto;
import syoux.apps.pos.domain.SearchStocktakingDomain;

@Mapper(componentModel = "spring")
public interface SearchStocktakingDtoMapper {
  @Mapping(target = "stocktakingId", source = "domain.stocktaking.id")
  @Mapping(target = "productId", source = "domain.product.id")
  @Mapping(target = "available", source = "domain.stocktaking.available")
  @Mapping(target = "name", source = "domain.product.name")
  @Mapping(target = "reference", source = "domain.product.reference")
  @Mapping(target = "price", source = "domain.product.price")
  @Mapping(target = "lastCost", source = "domain.stocktaking.lastCost")
  @Mapping(target = "averageCost", source = "domain.stocktaking.averageCost")
  SearchStocktakingDto map(SearchStocktakingDomain domain);
}
