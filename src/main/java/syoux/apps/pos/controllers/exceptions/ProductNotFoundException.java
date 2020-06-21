package syoux.apps.pos.controllers.exceptions;

public class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException(Long id) {
    super("Could not find the product " + id);
  }
}
