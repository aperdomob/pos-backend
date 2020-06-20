package syoux.apps.pos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import syoux.apps.pos.domain.SearchProductDomain;
import syoux.apps.pos.repository.ProductRepository;
import syoux.apps.pos.repository.StocktakingRepository;
import syoux.apps.pos.repository.entity.Product;

public class SearchProductService {
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private StocktakingRepository stocktakingRepository;

  public List<SearchProductDomain> find(String query) {
    List<Product> products = productRepository
        .findByNameAndReferenceAllIgnoreCase(query, query);

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
