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
import syoux.apps.pos.controllers.assembler.SearchStocktakingModelAssembler;
import syoux.apps.pos.controllers.dto.SearchStocktakingDto;
import syoux.apps.pos.controllers.mapper.SearchStocktakingDtoMapper;
import syoux.apps.pos.domain.SearchStocktakingDomain;
import syoux.apps.pos.services.interfaces.ISearchStocktakingService;

@RestController
@RequestMapping("search/stocktaking")
public class SearchStocktakingController {
  @Autowired
  private ISearchStocktakingService searchStocktakingService;

  @Autowired
  private SearchStocktakingModelAssembler assembler;

  @Autowired
  private SearchStocktakingDtoMapper mapper;

  @GetMapping("")
  public CollectionModel<EntityModel<SearchStocktakingDto>> find(@RequestParam(defaultValue = "") String q) {
    List<EntityModel<SearchStocktakingDto>> results = search(q)
        .stream()
        .map(result -> this.assembler.toModel(mapper.map(result)))
        .collect(Collectors.toList());;

    return CollectionModel.of(
        results,
        linkTo(methodOn(SearchStocktakingController.class).find(q)).withSelfRel()
    );
  }

  private List<SearchStocktakingDomain> search(String query) {
    if (query == null || query.isBlank()) {
      return this.searchStocktakingService.all();
    }

    return this.searchStocktakingService.search(query);
  }
}
