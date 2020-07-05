package syoux.apps.pos.controllers.endpoints.search;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import syoux.apps.pos.controllers.assembler.SearchProductModelAssembler;
import syoux.apps.pos.controllers.dto.SearchProductDto;
import syoux.apps.pos.controllers.mapper.SearchProductDtoMapper;
import syoux.apps.pos.domain.SearchProductDomain;
import syoux.apps.pos.services.interfaces.ISearchProductService;

@RestController
@RequestMapping("search/products")
public class SearchProductController {
  @Autowired
  private SearchProductModelAssembler assembler;

  @Autowired
  private SearchProductDtoMapper mapper;

  @Autowired
  ISearchProductService searchProductService;

  @GetMapping
  public CollectionModel<EntityModel<SearchProductDto>> find(@RequestParam(defaultValue = "") String q) {
    List<EntityModel<SearchProductDto>> results = search(q)
        .stream()
        .map(result -> this.assembler.toModel(mapper.map(result)))
        .collect(Collectors.toList());

    return CollectionModel.of(
        results,
        linkTo(methodOn(SearchProductController.class).find(q)).withSelfRel()
    );
  }

  private List<SearchProductDomain> search(String query) {
    if (query == null || query.isBlank()) {
      return this.searchProductService.all();
    }

    return this.searchProductService.search(query);
  }
}
