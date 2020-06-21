package syoux.apps.pos.services.interfaces;

import java.util.List;
import syoux.apps.pos.domain.StocktakingDomain;

public interface IStocktakingService {
  List<StocktakingDomain> all();

  StocktakingDomain create(StocktakingDomain stocktaking);

  StocktakingDomain one(Long id);

  StocktakingDomain update(StocktakingDomain stocktaking);

  void delete(Long id);
}
