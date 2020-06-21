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
  private String packaging;

  @Getter
  @Setter
  private Long available;

  @Getter
  @Setter
  private double averageCost;

  @Getter
  @Setter
  private double lastCost;
}
