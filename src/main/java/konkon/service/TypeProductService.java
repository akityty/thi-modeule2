package konkon.service;

import konkon.model.TypeProduct;

public interface TypeProductService {
  Iterable<TypeProduct> findAll();
  TypeProduct findById(Long id);
}
