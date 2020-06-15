package syoux.apps.pos.controllers.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import syoux.apps.pos.dto.SaleDto;
import syoux.apps.pos.repository.entity.Sale;

@Mapper(componentModel = "spring")
public interface SaleMapper {
  Sale dtoToEntity(SaleDto dto);
  SaleDto entityToDto(Sale entity);
}
