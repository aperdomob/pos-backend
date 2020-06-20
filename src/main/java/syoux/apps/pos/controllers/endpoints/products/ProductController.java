package syoux.apps.pos.controllers.endpoints.products;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import syoux.apps.pos.controllers.dto.ProductDto;
import syoux.apps.pos.controllers.mapper.ProductDtoMapper;
import syoux.apps.pos.services.interfaces.IProductService;

@RestController()
@RequestMapping("products")
public class ProductController {

  @Autowired
  private ProductDtoMapper productDtoMapper;

  @Autowired
  private IProductService productService;

  @GetMapping("")
  public List<ProductDto> getAllProducts() {
    return null;
  }

  @PostMapping("")
  public ProductDto create(@RequestBody ProductDto productDto) {
    ProductDto dto = productDtoMapper.domainToDto(productService.create(productDtoMapper.dtoToDomain(productDto)));
    return null;
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
