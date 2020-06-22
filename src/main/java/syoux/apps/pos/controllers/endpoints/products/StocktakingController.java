package syoux.apps.pos.controllers.endpoints.products;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import syoux.apps.pos.controllers.assembler.StocktakingModelAssembler;
import syoux.apps.pos.controllers.dto.StocktakingDto;
import syoux.apps.pos.controllers.mapper.StocktakingDtoMapper;
import syoux.apps.pos.domain.StocktakingDomain;
import syoux.apps.pos.services.interfaces.IStocktakingService;

@RestController()
@RequestMapping("products/{productId}/stocktaking")
public class StocktakingController {
  @Autowired
  private IStocktakingService stocktakingService;

  @Autowired
  private StocktakingModelAssembler assembler;

  @Autowired
  private StocktakingDtoMapper stocktakingDtoMapper;

  @GetMapping("")
  public CollectionModel<EntityModel<StocktakingDto>> all(@PathVariable Long productId) {
    List<EntityModel<StocktakingDto>> items = this.stocktakingService
        .allByProduct(productId)
        .stream()
        .map(item -> {
          return this.assembler.toModel(this.stocktakingDtoMapper.domainToDto(item));
        })
        .collect(Collectors.toList());

    return CollectionModel.of(items,
        linkTo(methodOn(StocktakingController.class).all(productId)).withSelfRel());
  }

  @PostMapping("")
  public ResponseEntity<?> create(@RequestBody StocktakingDto stocktakingDto) {
    StocktakingDto dto = stocktakingDtoMapper
        .domainToDto(stocktakingService.create(stocktakingDtoMapper.dtoToDomain(stocktakingDto)));
    EntityModel<StocktakingDto> model = assembler.toModel(dto);

    return ResponseEntity
        .created(model.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(model);
  }

  @GetMapping("/{id}")
  public EntityModel<StocktakingDto> one(@PathVariable Long id) {
    StocktakingDomain stocktaking = stocktakingService.one(id);
    StocktakingDto dto = stocktakingDtoMapper.domainToDto(stocktaking);

    return assembler.toModel(dto);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody StocktakingDto stocktakingDto) {
    stocktakingDto.setId(id);

    StocktakingDto dto = stocktakingDtoMapper
        .domainToDto((stocktakingService.update(stocktakingDtoMapper.dtoToDomain(stocktakingDto))));
    EntityModel<StocktakingDto> model = assembler.toModel(dto);

    return ResponseEntity
        .status(HttpStatus.OK)
        .location(model.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(model);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    stocktakingService.delete(id);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
