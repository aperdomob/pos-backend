package syoux.apps.pos.controllers.endpoints.sales;

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
import syoux.apps.pos.controllers.mapper.SaleDtoMapper;
import syoux.apps.pos.dto.SaleDto;
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

  @Autowired
  private SaleDtoMapper saleDtoMapper;

  @GetMapping()
  public CollectionModel<EntityModel<SaleDto>> all() {
    List<EntityModel<SaleDto>> sales = this
        .saleService
        .getAllSales()
        .stream()
        .map(saleDtoMapper::entityToDto)
        .map(assembler::toModel)
        .collect(Collectors.toList());

    return CollectionModel.of(
        sales,
        linkTo(methodOn(SaleController.class).all()).withSelfRel());
  }

  @GetMapping("/{id}")
  public EntityModel<SaleDto> one(@PathVariable Long id) {
    Sale sale = saleService.one(id);
    SaleDto dto = saleDtoMapper.entityToDto(sale);

    return assembler.toModel(dto);
  }

  @PostMapping("create")
  ResponseEntity<?> newSale() {
    SaleDto dto = this.saleDtoMapper.entityToDto(saleService.create());
    EntityModel<SaleDto> entityModel = assembler.toModel(dto);

    return ResponseEntity
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entityModel);
  }

  @PostMapping("/{id}/confirm")
  public ResponseEntity<?> confirm(@PathVariable Long id) {
    Sale sale = this.saleService.one(id);
    return null;

  }

  @PostMapping("/{id}/cancel")
  public ResponseEntity<?> cancel(@PathVariable Long id) {
    return null;
  }
}
