package syoux.apps.pos.controllers.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import syoux.apps.pos.controllers.dto.ProductDto;
import syoux.apps.pos.controllers.dto.SaleDto;
import syoux.apps.pos.domain.ProductDomain;
import syoux.apps.pos.domain.SaleDomain;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {
  ProductDomain dtoToDomain(ProductDto dto);

  @InheritInverseConfiguration
  ProductDto domainToDto(ProductDomain entity);
}
