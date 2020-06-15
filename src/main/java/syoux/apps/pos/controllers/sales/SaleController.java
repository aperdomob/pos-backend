package syoux.apps.pos.controllers.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import syoux.apps.pos.services.interfaces.ISaleService;

@RestController
@RequestMapping("sales")
public class SaleController {

  // Reserve a sale
  // Confirm a sale
  // Decline a sale
  // Add Item to a sale

  @Autowired
  private ISaleService saleService;

  @PostMapping("create")
  String newSale() {
    saleService.create();
    return "Created Sale";
  }
}
