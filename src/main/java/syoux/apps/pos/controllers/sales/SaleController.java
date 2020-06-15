package syoux.apps.pos.controllers.sales;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import syoux.apps.pos.controllers.assembler.SaleModelAssembler;
import syoux.apps.pos.controllers.exceptions.SaleNotFoundException;
import syoux.apps.pos.repository.entity.Sale;
import syoux.apps.pos.services.interfaces.ISaleService;

@RestController
@RequestMapping("sales")
public class SaleController {

  // Reserve a sale
  // Confirm a sale
  // Decline a sale
  // Add Item to a sale

  @Autowired
  private ISaleService saleService;

  @Autowired
  private SaleModelAssembler assembler;

  @GetMapping()
  public CollectionModel<EntityModel<Sale>> all() {
    List<EntityModel<Sale>> sales = this
        .saleService
        .getAllSales()
        .stream()
        .map(assembler::toModel)
        .collect(Collectors.toList());

    return CollectionModel.of(
        sales,
        linkTo(methodOn(SaleController.class).all()).withSelfRel());
  }

  @GetMapping("/{id}")
  public EntityModel<Sale> one(@PathVariable Long id) {
    Sale sale = saleService
        .one(id)
        .orElseThrow(() -> new SaleNotFoundException(id));

    return assembler.toModel(sale);
  }

  @PostMapping("create")
  ResponseEntity<?> newSale() {
    EntityModel<Sale> entityModel = assembler.toModel(saleService.create());

    return ResponseEntity
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entityModel);
  }
}
