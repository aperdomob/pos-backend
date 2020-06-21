package syoux.apps.pos.controllers.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import syoux.apps.pos.controllers.dto.ProductDto;
import syoux.apps.pos.controllers.dto.StocktakingDto;
import syoux.apps.pos.controllers.endpoints.products.ProductController;
import syoux.apps.pos.controllers.endpoints.stocktaking.StocktakingController;

@Component
public class StocktakingModelAssembler implements RepresentationModelAssembler<StocktakingDto, EntityModel<StocktakingDto>> {

  @Override
  public EntityModel<StocktakingDto> toModel(StocktakingDto stocktaking) {
    EntityModel<StocktakingDto> productModel = EntityModel.of(
        stocktaking,
        linkTo(methodOn(StocktakingController.class).one(stocktaking.getId())).withSelfRel(),
        linkTo(methodOn(StocktakingController.class).all()).withRel("stocktaking"));

    return productModel;
  }
}
