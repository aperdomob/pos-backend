package syoux.apps.pos.services.mapper;

import org.mapstruct.Mapper;
import syoux.apps.pos.domain.SaleDomain;
import syoux.apps.pos.repository.entity.Sale;

@Mapper(componentModel = "spring")
public interface SaleMapper {
  SaleDomain entityToDomain(Sale entity);
  Sale entityToDomain(SaleDomain domain);
}
