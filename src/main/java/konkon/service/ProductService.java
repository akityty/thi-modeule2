package konkon.service;

import konkon.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
  List<Product> findAll();
  List<Product> findAllByNameContaining(String name);
  void save(Product product);
  Product findById(Long id );
  void delete(Product product);
}
