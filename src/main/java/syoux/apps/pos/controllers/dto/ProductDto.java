package syoux.apps.pos.controllers.dto;

import lombok.Getter;
import lombok.Setter;

public class ProductDto {
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
