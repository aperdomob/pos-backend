package syoux.apps.pos.services.interfaces;

import java.util.List;
import syoux.apps.pos.domain.SearchProductDomain;

public interface ISearchProductService {
  List<SearchProductDomain> all();
  List<SearchProductDomain> search(String query);
}
