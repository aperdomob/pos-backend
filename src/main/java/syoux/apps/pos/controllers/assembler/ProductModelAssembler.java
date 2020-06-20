package syoux.apps.pos.controllers.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import syoux.apps.pos.controllers.dto.ProductDto;
import syoux.apps.pos.controllers.dto.SaleDto;
import syoux.apps.pos.controllers.endpoints.sales.SaleController;
import syoux.apps.pos.repository.entity.SaleStatus;

@Component
public class ProductModelAssembler implements RepresentationModelAssembler<ProductDto, EntityModel<ProductDto>> {

  @Override
  public EntityModel<ProductDto> toModel(ProductDto product) {
    EntityModel<ProductDto> productModel = EntityModel.of(
        product,
        linkTo(methodOn(SaleController.class).one(product.getId())).withSelfRel(),
        linkTo(methodOn(SaleController.class).all()).withRel("sales"));

    return productModel;
  }
}
