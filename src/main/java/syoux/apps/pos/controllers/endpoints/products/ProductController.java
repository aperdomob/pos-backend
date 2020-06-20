package syoux.apps.pos.controllers.endpoints.products;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.EntityMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import syoux.apps.pos.controllers.assembler.ProductModelAssembler;
import syoux.apps.pos.controllers.dto.ProductDto;
import syoux.apps.pos.controllers.dto.SaleDto;
import syoux.apps.pos.controllers.mapper.ProductDtoMapper;
import syoux.apps.pos.services.interfaces.IProductService;

@RestController()
@RequestMapping("products")
public class ProductController {

  @Autowired
  private ProductDtoMapper productDtoMapper;

  @Autowired
  private IProductService productService;

  @Autowired
  private ProductModelAssembler assembler;

  @GetMapping("")
  public CollectionModel<EntityModel<ProductDto>> all() {
    List<EntityModel<ProductDto>> products = this.productService
        .all()
        .stream()
        .map(product -> {
          return this.assembler.toModel(this.productDtoMapper.domainToDto(product));
        })
        .collect(Collectors.toList());

    return CollectionModel.of(
        products,
        linkTo(methodOn(ProductController.class).all()).withSelfRel()
    );
  }

  @PostMapping("")
  public ResponseEntity<?> create(@RequestBody ProductDto productDto) {
    ProductDto dto = productDtoMapper.domainToDto(productService.create(productDtoMapper.dtoToDomain(productDto)));
    EntityModel<ProductDto> model = assembler.toModel(dto);

    return ResponseEntity
        .created(model.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(model);
  }

  @GetMapping("/{id}")
  public ProductDto one(@PathVariable Long id) {
    return null;
  }

  @PutMapping("/{id}")
  public ProductDto update(@PathVariable Long id, @RequestBody ProductDto productDto) {
    return null;
  }
}
