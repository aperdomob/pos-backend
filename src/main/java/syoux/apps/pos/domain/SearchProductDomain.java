package syoux.apps.pos.domain;

import lombok.Getter;
import lombok.Setter;
import syoux.apps.pos.repository.entity.Product;
import syoux.apps.pos.repository.entity.Stocktaking;

public class SearchProductDomain {
  @Getter
  @Setter
  private Long productId;

  @Getter
  @Setter
  private String name;

  @Getter
  @Setter
  private String reference;

  @Getter
  @Setter
  private double price;

  @Getter
  @Setter
  private String packaging;

  @Getter
  @Setter
  private Long available;

  @Getter
  @Setter
  private Double cost;

  public SearchProductDomain() {
    this.cost = 0D;
    this.packaging = "";
    this.available = 0L;
  }

  public static SearchProductDomain buildFromProductAndStocktaking(Product product, Stocktaking stocktaking) {
    if (product.getId() != stocktaking.getProduct().getId()) {
      return null;
    }

    SearchProductDomain instance = new SearchProductDomain();
    instance.productId = product.getId();
    instance.name = product.getName();
    instance.reference = product.getName();
    instance.reference = product.getName();
    instance.price = product.getPrice();
    instance.packaging = stocktaking.getPackaging();
    instance.available = stocktaking.getAvailable();
    instance.cost = stocktaking.getAverageCost();

    return instance;
  }
}
