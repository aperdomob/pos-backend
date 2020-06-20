package syoux.apps.pos.controllers.exceptions;

public class SaleItemNotFoundException extends RuntimeException {
  public SaleItemNotFoundException(Long id) {
    super("Could not find sale item " + id);
  }
}
