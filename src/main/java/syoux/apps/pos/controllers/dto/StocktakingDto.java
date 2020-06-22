package syoux.apps.pos.controllers.dto;

import lombok.Getter;
import lombok.Setter;

public class StocktakingDto {
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
  private double averageCost;

  @Getter
  @Setter Long productId;
}
