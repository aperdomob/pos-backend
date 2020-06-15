package syoux.apps.pos.controllers.products;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("products")
public class ProductController {

  @RequestMapping("")
  public String getAllProducts() {
    return "Get All Products";
  }
}
