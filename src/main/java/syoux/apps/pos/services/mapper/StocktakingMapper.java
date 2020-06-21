package syoux.apps.pos.services.mapper;

import org.mapstruct.Mapper;
import syoux.apps.pos.domain.StocktakingDomain;
import syoux.apps.pos.repository.entity.Stocktaking;

@Mapper(componentModel = "spring")
public interface StocktakingMapper {
  StocktakingDomain entityToDomain(Stocktaking entity);
  Stocktaking domainToEntity(StocktakingDomain domain);
}
