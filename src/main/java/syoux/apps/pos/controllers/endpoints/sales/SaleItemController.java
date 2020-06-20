package syoux.apps.pos.controllers.endpoints.sales;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import syoux.apps.pos.controllers.assembler.SaleItemModelAssembler;
import syoux.apps.pos.controllers.mapper.SaleItemDtoMapper;
import syoux.apps.pos.domain.SaleItemDomain;
import syoux.apps.pos.dto.SaleItemDto;
import syoux.apps.pos.services.interfaces.ISaleService;

@RestController
@RequestMapping("sales/{saleId}/items")
public class SaleItemController {
  @Autowired
  private ISaleService saleService;

  @Autowired
  private SaleItemDtoMapper saleItemDtoMapper;

  @Autowired
  private SaleItemModelAssembler assembler;

  @PostMapping("")
  ResponseEntity<?> newItem(@PathVariable Long saleId, @RequestBody SaleItemDto saleItemDto) {
    this.saleService.addItem(saleId, saleItemDtoMapper.dtoToDomain(saleItemDto));

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("")
  public CollectionModel<EntityModel<SaleItemDto>> itemsBySales(@PathVariable Long saleId) {
    List<EntityModel<SaleItemDto>> items = saleService
        .getItems(saleId)
        .stream()
        .map(saleItemDomain -> {
          return assembler.toModel(saleItemDtoMapper.domainToDto(saleItemDomain));
        })
        .collect(Collectors.toList());

    return CollectionModel.of(
        items,
        linkTo(methodOn(SaleItemController.class).itemsBySales(saleId)).withSelfRel());
  }

  @GetMapping("{id}")
  public EntityModel<SaleItemDto> one(@PathVariable Long saleId, @PathVariable Long id) {
    SaleItemDomain item = saleService.getItem(saleId, id);

    return this.assembler.toModel(this.saleItemDtoMapper.domainToDto(item));
  }
}
