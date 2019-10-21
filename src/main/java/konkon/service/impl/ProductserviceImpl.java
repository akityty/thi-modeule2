package konkon.service.impl;

import konkon.model.Product;
import konkon.repository.ProductRepository;
import konkon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Transactional
public class ProductserviceImpl implements ProductService {
  @PersistenceContext
  private EntityManager em;
  @Autowired
  private ProductRepository productRepository;
  @Override
  public List<Product> findAll() {
    return (List<Product>) productRepository.findAll();
  }

  @Override
  public List<Product> findAllByNameContaining(String name) {
    return productRepository.findAllByNameContaining(name);
  }

  @Override
  public void save(Product product) {
   if(product.getId() != null){
     em.merge(product);
   }else{
     em.persist(product);
   }
  }

  @Override
  public Product findById(Long id) {
    return productRepository.findOne(id);
  }

  @Override
  public void delete(Product product) {
    productRepository.delete(product.getId());
  }
}
