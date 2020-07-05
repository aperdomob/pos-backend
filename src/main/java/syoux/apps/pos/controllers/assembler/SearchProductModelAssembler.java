package syoux.apps.pos.controllers.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import syoux.apps.pos.controllers.dto.SearchProductDto;
import syoux.apps.pos.controllers.endpoints.products.ProductController;
import syoux.apps.pos.controllers.endpoints.products.ProductStocktakingController;

@Component
public class SearchProductModelAssembler implements
    RepresentationModelAssembler<SearchProductDto, EntityModel<SearchProductDto>> {

  @Override
  public EntityModel<SearchProductDto> toModel(SearchProductDto dto) {
    EntityModel<SearchProductDto> model = EntityModel.of(
        dto,
        linkTo(methodOn(ProductController.class).one(dto.getProductId())).withRel("product")
    );

    return model;
  }
}
