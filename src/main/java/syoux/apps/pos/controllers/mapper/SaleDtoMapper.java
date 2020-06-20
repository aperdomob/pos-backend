package syoux.apps.pos.controllers.mapper;

import org.mapstruct.Mapper;
import syoux.apps.pos.domain.SaleDomain;
import syoux.apps.pos.dto.SaleDto;

@Mapper(componentModel = "spring")
public interface SaleDtoMapper {
  SaleDomain dtoToDomain(SaleDto dto);
  SaleDto domainToDto(SaleDomain entity);
}
