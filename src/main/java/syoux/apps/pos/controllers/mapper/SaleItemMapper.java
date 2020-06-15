package syoux.apps.pos.controllers.mapper;

import org.mapstruct.Mapper;
import syoux.apps.pos.dto.SaleItemDto;
import syoux.apps.pos.repository.entity.SaleItem;

@Mapper(componentModel = "spring")
public interface SaleItemMapper {
  SaleItemDto entityToDto(SaleItem entity);
  SaleItem dtoToEntity(SaleItemDto dto);
}
