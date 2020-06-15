package syoux.apps.pos.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class SaleItem {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String reference;
  private int amount;
  private double price;
  private double deduction;

//  @Getter
//  @Setter
//  @ManyToOne
//  private Sale sale;
}
