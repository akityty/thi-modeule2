package konkon.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "typeProduct")
public class TypeProduct {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  @OneToMany(mappedBy = "typeProduct")
  private List<Product> products;

  public TypeProduct(String name, List<Product> products) {
    this.name = name;
    this.products = products;
  }

  public TypeProduct() {
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

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }
}
