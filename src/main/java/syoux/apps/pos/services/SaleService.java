package syoux.apps.pos.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import syoux.apps.pos.controllers.exceptions.SaleNotFoundException;
import syoux.apps.pos.domain.SaleDomain;
import syoux.apps.pos.domain.SaleItemDomain;
import syoux.apps.pos.repository.SaleItemRepository;
import syoux.apps.pos.repository.SaleRepository;
import syoux.apps.pos.repository.entity.Sale;
import syoux.apps.pos.repository.entity.SaleItem;
import syoux.apps.pos.services.interfaces.ISaleService;
import syoux.apps.pos.services.mapper.SaleItemMapper;
import syoux.apps.pos.services.mapper.SaleMapper;

@Service
public class SaleService implements ISaleService {
  private final SaleRepository saleRepository;
  private final SaleItemRepository saleItemRepository;

  private final SaleMapper saleMapper;
  private final SaleItemMapper saleItemMapper;

  SaleService(
      SaleRepository saleRepository,
      SaleItemRepository saleItemRepository,
      SaleMapper saleMapper, SaleItemMapper saleItemMapper) {
    this.saleRepository = saleRepository;
    this.saleItemRepository = saleItemRepository;
    this.saleMapper = saleMapper;
    this.saleItemMapper = saleItemMapper;
  }

  @Override
  public SaleDomain create()
  {
    Sale saleEntity = saleRepository.save(this.saleMapper.domainToEntity(new SaleDomain()));

    return this.saleMapper.entityToDomain(saleEntity);
  }

  @Override
  public void addItem(Long id, SaleItemDomain item) {
    Sale sale = this.getSaleFromRepository(id);

    SaleItem entity = this.saleItemMapper.domainToEntity(item);
    entity.setSale(sale);

    this.saleItemRepository.save(entity);
  }

  @Override
  public List<SaleItemDomain> getAllItems() {
    return this.saleItemRepository
        .findAll()
        .stream()
        .map(saleItemMapper::entityToDomain)
        .collect(Collectors.toList());
  }

  @Override
  public List<SaleDomain> getAllSales() {
    return saleRepository
        .findAll()
        .stream()
        .map(saleMapper::entityToDomain)
        .collect(Collectors.toList());
  }

  @Override
  public SaleDomain one(Long id) {
    return this.saleMapper.entityToDomain(this.getSaleFromRepository(id));
  }

  private Sale getSaleFromRepository(Long id) {
    return this.saleRepository
        .findById(id)
        .orElseThrow(() -> new SaleNotFoundException(id));
  }
}
