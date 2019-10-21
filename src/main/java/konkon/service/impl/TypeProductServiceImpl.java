package konkon.service.impl;

import konkon.model.TypeProduct;
import konkon.repository.TypeProductRepository;
import konkon.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class TypeProductServiceImpl implements TypeProductService {
  @Autowired
  private TypeProductRepository typeProductRepository;
  @Override
  public Iterable<TypeProduct> findAll() {
    return typeProductRepository.findAll();
  }

  @Override
  public TypeProduct findById(Long id) {
    return typeProductRepository.findOne(id);
  }
}
