package syoux.apps.pos.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import syoux.apps.pos.domain.SaleItemDomain;
import syoux.apps.pos.repository.entity.SaleItem;

@Mapper(componentModel = "spring")
public interface SaleItemMapper {
  SaleItemDomain entityToDomain(SaleItem entity);

  @Mapping(target = "sale", ignore = true)
  SaleItem domainToEntity(SaleItemDomain domain);
}
