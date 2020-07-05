package syoux.apps.pos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import syoux.apps.pos.domain.SearchProductDomain;
import syoux.apps.pos.repository.ProductRepository;
import syoux.apps.pos.repository.StocktakingRepository;
import syoux.apps.pos.repository.entity.Product;
import syoux.apps.pos.services.interfaces.ISearchProductService;

@Service
public class SearchProductService implements ISearchProductService {
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private StocktakingRepository stocktakingRepository;

  @Override
  public List<SearchProductDomain> all() {
    return null;
  }

  @Override
  public List<SearchProductDomain> search(String query) {
    List<Product> products = productRepository
        .findByNameContainingOrReferenceContainingAllIgnoreCase(query, query);

    List<SearchProductDomain> searchResults = new ArrayList<>();

    for (Product product: products) {
      List<SearchProductDomain> results = stocktakingRepository
          .findByProduct(product)
          .stream()
          .map(stocktaking -> SearchProductDomain.buildFromProductAndStocktaking(product, stocktaking))
          .collect(Collectors.toList());

      searchResults.addAll(results);
    }

    return searchResults;
  }
}
