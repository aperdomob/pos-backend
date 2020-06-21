package syoux.apps.pos.controllers.exceptions;

public class StocktakingNotFoundException extends RuntimeException {
  public StocktakingNotFoundException(Long id) {
    super("Could not find the item " + id + "into the stocktaking");
  }
}
