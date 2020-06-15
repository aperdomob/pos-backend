package syoux.apps.pos.repository.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Sale {

  @Id
  @GeneratedValue
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
  @OneToMany(targetEntity = SaleItem.class)
  private List<SaleItem> items;

  public Sale() {
    this.date = new Date();
    this.items = new ArrayList<>();
    this.status = SaleStatus.CREATED;
  }

  @Override
  public boolean equals(Object obj) {
    if ( this == obj) {
      return true;
    }

    if(!(obj instanceof Sale)) {
      return  false;
    }

    Sale sale = (Sale) obj;

    return Objects.equals(this.id, sale.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }
}
