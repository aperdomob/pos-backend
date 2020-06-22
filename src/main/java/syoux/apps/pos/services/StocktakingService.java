package syoux.apps.pos.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import syoux.apps.pos.controllers.exceptions.StocktakingNotFoundException;
import syoux.apps.pos.domain.StocktakingDomain;
import syoux.apps.pos.repository.StocktakingRepository;
import syoux.apps.pos.repository.entity.Stocktaking;
import syoux.apps.pos.services.interfaces.IStocktakingService;
import syoux.apps.pos.services.mapper.StocktakingMapper;

@Service
public class StocktakingService implements IStocktakingService {

  @Autowired
  private StocktakingRepository stocktakingRepository;

  @Autowired
  private StocktakingMapper mapper;

  @Override
  public List<StocktakingDomain> allByProduct(Long productId) {
    return stocktakingRepository
        .findAll()
        .stream()
        .map(mapper::entityToDomain)
        .collect(Collectors.toList());
  }

  @Override
  public StocktakingDomain create(StocktakingDomain stocktaking) {
    Stocktaking entity = stocktakingRepository.save(mapper.domainToEntity(stocktaking));
    return mapper.entityToDomain(entity);
  }

  @Override
  public StocktakingDomain one(Long id) {
    return mapper.entityToDomain(this.getEntity(id));
  }

  @Override
  public StocktakingDomain update(StocktakingDomain stocktaking) {
    Stocktaking entity = this.getEntity(stocktaking.getId());

    entity.setAvailable(stocktaking.getAvailable());
    entity.setLastCost(stocktaking.getLastCost());

    return mapper.entityToDomain(stocktakingRepository.save(entity));
  }

  @Override
  public void delete(Long id) {
    Stocktaking entity = stocktakingRepository
        .findById(id)
        .orElse(null);

    if (entity != null) {
      stocktakingRepository.delete(entity);
    }
  }

  private Stocktaking getEntity(Long id) {
    return stocktakingRepository
        .findById(id)
        .orElseThrow(() -> new StocktakingNotFoundException(id));
  }
}
