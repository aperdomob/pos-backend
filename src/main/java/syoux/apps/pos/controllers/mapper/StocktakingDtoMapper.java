package syoux.apps.pos.controllers.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import syoux.apps.pos.controllers.dto.ProductDto;
import syoux.apps.pos.controllers.dto.StocktakingDto;
import syoux.apps.pos.domain.ProductDomain;
import syoux.apps.pos.domain.StocktakingDomain;

@Mapper(componentModel = "spring")
public interface StocktakingDtoMapper {
  StocktakingDomain dtoToDomain(StocktakingDto dto);

  @InheritInverseConfiguration
  StocktakingDto domainToDto(StocktakingDomain entity);
}
