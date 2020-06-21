package syoux.apps.pos.domain;

import lombok.Getter;
import lombok.Setter;

public class StocktakingDomain {
  @Getter
  @Setter
  private Long id;

  @Getter
  @Setter
  private Long available;

  @Getter
  @Setter
  private double lastCost;

  @Getter
  @Setter
  private String packaging;
}
