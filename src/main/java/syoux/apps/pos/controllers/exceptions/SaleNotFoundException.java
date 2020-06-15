package syoux.apps.pos.controllers.exceptions;

public class SaleNotFoundException extends RuntimeException {
  public SaleNotFoundException(Long id) {
    super("Could not find sale " + id);
  }
}
