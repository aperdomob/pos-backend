package syoux.apps.pos.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import syoux.apps.pos.repository.entity.SaleStatus;

public class SaleDomain {
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
  private List<SaleItemDomain> items;

  public SaleDomain() {
    this.date = new Date();
    this.status = SaleStatus.CREATED;
    this.items = new ArrayList<>();
  }
}
