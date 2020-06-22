package syoux.apps.pos.services.interfaces;

import java.util.List;
import syoux.apps.pos.domain.SearchStocktakingDomain;

public interface ISearchStocktakingService {

  List<SearchStocktakingDomain> all();

  List<SearchStocktakingDomain> seach(String query);
}
