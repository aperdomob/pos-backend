package syoux.apps.pos.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import syoux.apps.pos.controllers.exceptions.SaleItemNotFoundException;
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
  public SaleItemDomain addItem(Long id, SaleItemDomain item) {
    Sale sale = this.getSaleFromRepository(id);

    SaleItem entity = this.saleItemMapper.domainToEntity(item);
    entity.setSale(sale);

    return this.saleItemMapper.entityToDomain(this.saleItemRepository.save(entity));
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
  public SaleItemDomain getItem(Long saleId, Long id) {
    return saleItemMapper.entityToDomain(getSaleItemFromRepository(id));
  }

  @Override
  public List<SaleItemDomain> getItems(Long saleId) {
    Sale sale = this.getSaleFromRepository(saleId);

    return this.getItemsFromSale(sale);
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
    Sale saleEntity = this.getSaleFromRepository(id);
    SaleDomain sale = this.saleMapper.entityToDomain(saleEntity);

    sale.setItems(this.getItemsFromSale(saleEntity));

    return sale;
  }

  private Sale getSaleFromRepository(Long id) {
    return this.saleRepository
        .findById(id)
        .orElseThrow(() -> new SaleNotFoundException(id));
  }

  private SaleItem getSaleItemFromRepository(Long id) {
    return this.saleItemRepository
        .findById(id)
        .orElseThrow(() -> new SaleItemNotFoundException(id));
  }

  public List<SaleItemDomain> getItemsFromSale(Sale sale) {
    return this.saleItemRepository
        .findBySale(sale)
        .stream()
        .map(saleItemMapper::entityToDomain)
        .collect(Collectors.toList());
  }
}
