package syoux.apps.pos.controllers.mapper;

import org.mapstruct.Mapper;
import syoux.apps.pos.controllers.dto.SearchProductDto;
import syoux.apps.pos.domain.SearchProductDomain;

@Mapper(componentModel = "spring")
public interface SearchProductDtoMapper {
  SearchProductDto map(SearchProductDomain domain);
}
