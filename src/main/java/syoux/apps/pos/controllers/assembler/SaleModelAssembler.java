package syoux.apps.pos.controllers.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import syoux.apps.pos.controllers.endpoints.sales.SaleController;
import syoux.apps.pos.controllers.dto.SaleDto;
import syoux.apps.pos.repository.entity.SaleStatus;

@Component
public class SaleModelAssembler implements RepresentationModelAssembler<SaleDto, EntityModel<SaleDto>> {

  @Override
  public EntityModel<SaleDto> toModel(SaleDto sale) {
    EntityModel<SaleDto> saleModel = EntityModel.of(
        sale,
        linkTo(methodOn(SaleController.class).one(sale.getId())).withSelfRel(),
        linkTo(methodOn(SaleController.class).all()).withRel("sales"));

    if (sale.getStatus() == SaleStatus.CREATED) {
      saleModel.add(linkTo(methodOn(SaleController.class).confirm(sale.getId())).withRel("confirm"));
      saleModel.add(linkTo(methodOn(SaleController.class).cancel(sale.getId())).withRel("cancel"));
    }

    return saleModel;
  }
}
