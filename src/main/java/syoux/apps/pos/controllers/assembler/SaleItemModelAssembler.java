package syoux.apps.pos.controllers.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import syoux.apps.pos.controllers.endpoints.sales.SaleController;
import syoux.apps.pos.controllers.endpoints.sales.SaleItemController;
import syoux.apps.pos.dto.SaleDto;
import syoux.apps.pos.dto.SaleItemDto;
import syoux.apps.pos.repository.entity.SaleItem;
import syoux.apps.pos.repository.entity.SaleStatus;

@Component
public class SaleItemModelAssembler implements RepresentationModelAssembler<SaleItemDto, EntityModel<SaleItemDto>> {

  @Override
  public EntityModel<SaleItemDto> toModel(SaleItemDto item) {
    EntityModel<SaleItemDto> saleModel = EntityModel.of(
        item,
        linkTo(methodOn(SaleItemController.class).one(item.getSaleId(), item.getId())).withSelfRel(),
        linkTo(methodOn(SaleController.class).all()).withRel("items"));

    return saleModel;
  }
}
