package syoux.apps.pos.controllers.endpoints.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import syoux.apps.pos.controllers.mapper.SaleItemMapper;
import syoux.apps.pos.dto.SaleItemDto;
import syoux.apps.pos.services.interfaces.ISaleService;

@RestController
@RequestMapping("sales/{id}/items")
public class SaleItemController {
  @Autowired
  private ISaleService saleService;

  @Autowired
  private SaleItemMapper saleItemMapper;

  @PostMapping("")
  ResponseEntity<?> newItem(@PathVariable Long id, @RequestBody SaleItemDto saleItemDto) {
    this.saleService.addItem(id, saleItemMapper.dtoToEntity(saleItemDto));

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
