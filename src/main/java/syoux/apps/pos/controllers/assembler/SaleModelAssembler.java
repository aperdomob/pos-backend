package syoux.apps.pos.controllers.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import syoux.apps.pos.controllers.sales.SaleController;
import syoux.apps.pos.repository.entity.Sale;

@Component
public class SaleModelAssembler implements RepresentationModelAssembler<Sale, EntityModel<Sale>> {

  @Override
  public EntityModel<Sale> toModel(Sale sale) {
    return EntityModel.of(
        sale,
        linkTo(methodOn(SaleController.class).one(sale.getId())).withSelfRel(),
        linkTo(methodOn(SaleController.class).all()).withRel("sales"));
  }
}
