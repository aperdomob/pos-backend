package syoux.apps.pos.domain;

import lombok.Getter;
import lombok.Setter;

public class SaleItemDomain {
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
  private int amount;

  @Getter
  @Setter
  private double price;

  @Getter
  @Setter
  private double deduction;
}
