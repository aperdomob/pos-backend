package syoux.apps.pos.repository.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Stocktaking {
  @Id
  @GeneratedValue
  @Getter
  @Setter
  private Long id;

  @Getter
  @Setter
  @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
  private Product product;

  @Getter
  @Setter
  private Long available;

  @Getter
  @Setter
  private double averageCost;

  @Getter
  @Setter
  private double lastCost;

  public Stocktaking(Product product) {
    this.product = product;
    this.available = 0L;
    this.averageCost = 0;
    this.lastCost = 0;
  }

  public Stocktaking() {
    this(null);
  }
}
