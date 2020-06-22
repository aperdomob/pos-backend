package syoux.apps.pos.domain;

import lombok.Getter;
import lombok.Setter;

public class SearchStocktakingDomain {
  @Getter
  @Setter
  private ProductDomain product;

  @Getter
  @Setter
  private StocktakingDomain stocktaking;
}
