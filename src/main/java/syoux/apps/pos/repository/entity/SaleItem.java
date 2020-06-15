package syoux.apps.pos.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
