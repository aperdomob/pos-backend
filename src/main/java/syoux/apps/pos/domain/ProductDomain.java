package syoux.apps.pos.domain;

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
}
