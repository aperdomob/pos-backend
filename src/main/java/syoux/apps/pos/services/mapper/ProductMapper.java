package syoux.apps.pos.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import syoux.apps.pos.domain.ProductDomain;
import syoux.apps.pos.domain.SaleDomain;
import syoux.apps.pos.repository.entity.Product;
import syoux.apps.pos.repository.entity.Sale;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  @Mapping(target = "items", ignore = true)
  ProductDomain entityToDomain(Product entity);
  Product domainToEntity(ProductDomain domain);
}
