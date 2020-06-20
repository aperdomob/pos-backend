package syoux.apps.pos.controllers.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import syoux.apps.pos.domain.SaleItemDomain;
import syoux.apps.pos.dto.SaleItemDto;

@Mapper(componentModel = "spring")
public interface SaleItemDtoMapper {
  @Mapping(target = "saleId", ignore = true)
  SaleItemDto domainToDto(SaleItemDomain entity);

  @InheritInverseConfiguration
  SaleItemDomain dtoToDomain(SaleItemDto dto);
}
