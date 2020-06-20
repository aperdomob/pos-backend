package syoux.apps.pos.controllers.mapper;

import org.mapstruct.Mapper;
import syoux.apps.pos.domain.SaleItemDomain;
import syoux.apps.pos.dto.SaleItemDto;

@Mapper(componentModel = "spring")
public interface SaleItemDtoMapper {
  SaleItemDto domainToDto(SaleItemDomain entity);
  SaleItemDomain dtoToDomain(SaleItemDto dto);
}
