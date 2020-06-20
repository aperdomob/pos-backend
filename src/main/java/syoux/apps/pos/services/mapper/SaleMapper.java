package syoux.apps.pos.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import syoux.apps.pos.domain.SaleDomain;
import syoux.apps.pos.repository.entity.Sale;

@Mapper(componentModel = "spring")
public interface SaleMapper {
  @Mapping(target = "items", ignore = true)
  SaleDomain entityToDomain(Sale entity);
  Sale domainToEntity(SaleDomain domain);
}
