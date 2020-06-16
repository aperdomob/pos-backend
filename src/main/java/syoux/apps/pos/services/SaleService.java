package syoux.apps.pos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import syoux.apps.pos.controllers.exceptions.SaleNotFoundException;
import syoux.apps.pos.repository.SaleRepository;
import syoux.apps.pos.repository.entity.Sale;
import syoux.apps.pos.repository.entity.SaleItem;
import syoux.apps.pos.services.interfaces.ISaleService;

@Service
public class SaleService implements ISaleService {
  private final SaleRepository saleRepository;

  SaleService(SaleRepository saleRepository) {
    this.saleRepository = saleRepository;
  }

  @Override
  public Sale create() {
    return saleRepository.save(new Sale());
  }

  @Override
  public void addItem(Long id, SaleItem item) {
    Sale sale = this.one(id);

    sale.getItems().add(item);
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
