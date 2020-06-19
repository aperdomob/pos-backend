package syoux.apps.pos.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import syoux.apps.pos.controllers.exceptions.SaleNotFoundException;
import syoux.apps.pos.repository.SaleItemRepository;
import syoux.apps.pos.repository.SaleRepository;
import syoux.apps.pos.repository.entity.Sale;
import syoux.apps.pos.repository.entity.SaleItem;
import syoux.apps.pos.services.interfaces.ISaleService;

@Service
public class SaleService implements ISaleService {
  private final SaleRepository saleRepository;
  private final SaleItemRepository saleItemRepository;

  @PersistenceContext // or even @Autowired
  private EntityManager entityManager;

  SaleService(SaleRepository saleRepository,
      SaleItemRepository saleItemRepository) {
    this.saleRepository = saleRepository;
    this.saleItemRepository = saleItemRepository;
  }

  @Override
  public Sale create() {
    return saleRepository.save(new Sale());
  }

  @Override
  public void addItem(Long id, SaleItem item) {
    Sale sale = this.one(id);
    // sale.addItem(item);

    this.saleItemRepository.save(item);
  }

  @Override
  public List<SaleItem> getAllItems() {
    return this.saleItemRepository.findAll();
  }

  @Override
  public List<Sale> getAllSales() {
    return saleRepository.findAll();
  }

  @Override
  public Sale one(Long id) {
    return saleRepository
        .findById(id).orElseThrow(() -> new SaleNotFoundException(id));
  }
}
