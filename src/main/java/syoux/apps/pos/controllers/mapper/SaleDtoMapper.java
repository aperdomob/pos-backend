package syoux.apps.pos.controllers.mapper;

import org.mapstruct.Mapper;
import syoux.apps.pos.dto.SaleDto;
import syoux.apps.pos.repository.entity.Sale;

@Mapper(componentModel = "spring")
public interface SaleDtoMapper {
  Sale dtoToEntity(SaleDto dto);
  SaleDto entityToDto(Sale entity);
}
