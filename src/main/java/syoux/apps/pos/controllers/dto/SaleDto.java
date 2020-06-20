package syoux.apps.pos.controllers.dto;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import syoux.apps.pos.repository.entity.SaleStatus;

public class SaleDto {
  @Getter
  @Setter
  private Long id;

  @Getter
  @Setter
  private Date date;

  @Getter
  @Setter
  private SaleStatus status;

  @Getter
  @Setter
  private List<SaleItemDto> items;
}
