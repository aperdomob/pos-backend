package syoux.apps.pos.controllers.dto;

import lombok.Getter;
import lombok.Setter;

public class SearchStocktakingDto {
  @Getter
  @Setter
  private Long stocktakingId;

  @Getter
  @Setter
  private Long productId;

  @Getter
  @Setter
  private Long available;

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
  private double lastCost;

  @Getter
  @Setter
  private double averageCost;
}
