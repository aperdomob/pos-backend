package syoux.apps.pos.services;

import org.springframework.stereotype.Service;
import syoux.apps.pos.repository.SaleRepository;
import syoux.apps.pos.repository.entity.Sale;
import syoux.apps.pos.services.interfaces.ISaleService;

@Service
public class SaleService implements ISaleService {
  private final SaleRepository saleRepository;

  SaleService(SaleRepository saleRepository) {
    this.saleRepository = saleRepository;
  }

  @Override
  public void create() {
    Sale sale = saleRepository.save(new Sale());
  }
}
