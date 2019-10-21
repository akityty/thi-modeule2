package konkon.repository;

import konkon.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
  List<Product> findAllByNameContaining(String name);
}
