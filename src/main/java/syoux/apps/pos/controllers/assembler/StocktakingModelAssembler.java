package syoux.apps.pos.controllers.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import syoux.apps.pos.controllers.dto.StocktakingDto;
import syoux.apps.pos.controllers.endpoints.products.ProductController;
import syoux.apps.pos.controllers.endpoints.products.ProductStocktakingController;

@Component
public class StocktakingModelAssembler implements RepresentationModelAssembler<StocktakingDto, EntityModel<StocktakingDto>> {

  @Override
  public EntityModel<StocktakingDto> toModel(StocktakingDto stocktaking) {
    EntityModel<StocktakingDto> productModel = EntityModel.of(
        stocktaking,
        linkTo(methodOn(ProductStocktakingController.class).one(stocktaking.getProductId(), stocktaking.getId())).withSelfRel(),
        linkTo(methodOn(ProductStocktakingController.class).all(stocktaking.getProductId())).withRel("stocktaking"),
        linkTo(methodOn(ProductController.class).one(stocktaking.getProductId())).withRel("product")
      );

    return productModel;
  }
}
