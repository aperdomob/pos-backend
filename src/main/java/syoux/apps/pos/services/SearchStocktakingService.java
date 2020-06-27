package syoux.apps.pos.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import syoux.apps.pos.domain.SearchStocktakingDomain;
import syoux.apps.pos.repository.ProductRepository;
import syoux.apps.pos.repository.StocktakingRepository;
import syoux.apps.pos.services.interfaces.ISearchStocktakingService;
import syoux.apps.pos.services.mapper.SearchStocktakingMapper;

@Service
public class SearchStocktakingService implements ISearchStocktakingService {
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  StocktakingRepository stocktakingRepository;

  @Autowired
  SearchStocktakingMapper mapper;

  @Override
  public List<SearchStocktakingDomain> all() {
    return stocktakingRepository
        .findAll()
        .stream()
        .map(mapper::map)
        .collect(Collectors.toList());
  }

  @Override
  public List<SearchStocktakingDomain> search(String query) {
    return Collections.emptyList();
  }
}
