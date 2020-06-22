package syoux.apps.pos.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class ProductDomain {
  @Getter
  @Setter
  private Long id;

  @Getter
  @Setter
  private String name;

  @Getter
  @Setter
  private String reference;

  @Getter
  @Setter
  private String price;

  @Getter
  @Setter
  private List<StocktakingDomain> stocktaking;

  public ProductDomain() {
    this.stocktaking = new ArrayList<>();
  }
}
