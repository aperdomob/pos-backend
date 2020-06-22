package syoux.apps.pos.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import syoux.apps.pos.domain.StocktakingDomain;
import syoux.apps.pos.repository.entity.Stocktaking;

@Mapper(componentModel = "spring")
public interface StocktakingMapper {
  StocktakingDomain entityToDomain(Stocktaking entity);
  @Mapping(target = "product", ignore = true)
  Stocktaking domainToEntity(StocktakingDomain domain);
}
