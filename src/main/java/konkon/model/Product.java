package konkon.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private  String name;
  private Double price;
  private Long amount;
  private LocalDate date;
  private String descriprion;
  @ManyToOne
  @JoinColumn(name = "typeProduct_id")
  private TypeProduct typeProduct;

  public Product(String name, Double price, Long amount, LocalDate date, String descriprion, TypeProduct typeProduct) {
    this.name = name;
    this.price = price;
    this.amount = amount;
    this.date = date;
    this.descriprion = descriprion;
    this.typeProduct = typeProduct;
  }
  public Product(Long id,String name, Double price, Long amount, LocalDate date, String descriprion, TypeProduct typeProduct) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.amount = amount;
    this.date = date;
    this.descriprion = descriprion;
    this.typeProduct = typeProduct;
  }

  public Product() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getDescriprion() {
    return descriprion;
  }

  public void setDescriprion(String descriprion) {
    this.descriprion = descriprion;
  }

  public TypeProduct getTypeProduct() {
    return typeProduct;
  }

  public void setTypeProduct(TypeProduct typeProduct) {
    this.typeProduct = typeProduct;
  }
}
