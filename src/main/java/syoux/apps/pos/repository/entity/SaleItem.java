package syoux.apps.pos.repository.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class SaleItem {
  @Id
  @GeneratedValue
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

  @Getter
  @Setter
  @ManyToOne(targetEntity = Sale.class, fetch = FetchType.LAZY)
  private Sale sale;
}
