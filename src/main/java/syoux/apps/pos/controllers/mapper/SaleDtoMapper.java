package syoux.apps.pos.controllers.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import syoux.apps.pos.domain.SaleDomain;
import syoux.apps.pos.controllers.dto.SaleDto;

@Mapper(componentModel = "spring")
public interface SaleDtoMapper {
  SaleDomain dtoToDomain(SaleDto dto);

  @InheritInverseConfiguration
  SaleDto domainToDto(SaleDomain entity);
}
