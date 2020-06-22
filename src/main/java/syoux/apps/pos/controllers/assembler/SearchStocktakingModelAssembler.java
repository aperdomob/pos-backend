package syoux.apps.pos.controllers.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import syoux.apps.pos.controllers.dto.SearchStocktakingDto;
import syoux.apps.pos.controllers.endpoints.products.ProductController;
import syoux.apps.pos.controllers.endpoints.products.StocktakingController;

@Component
public class SearchStocktakingModelAssembler implements RepresentationModelAssembler<SearchStocktakingDto, EntityModel<SearchStocktakingDto>> {

  @Override
  public EntityModel<SearchStocktakingDto> toModel(SearchStocktakingDto dto) {
    EntityModel<SearchStocktakingDto> model = EntityModel.of(
        dto,
        linkTo(methodOn(StocktakingController.class).one(dto.getProductId(), dto.getStocktakingId())).withRel("stocktaking"),
        linkTo(methodOn(ProductController.class).one(dto.getProductId())).withRel("product"));

    return model;
  }
}
