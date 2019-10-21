package konkon.formatter;


import konkon.model.TypeProduct;
import konkon.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class TypeProductFormatter implements Formatter<TypeProduct> {

  private TypeProductService typeProductService;

  @Autowired
  public TypeProductFormatter(TypeProductService typeProductService) {
    this.typeProductService = typeProductService;
  }

  @Override
  public TypeProduct parse(String text, Locale locale) throws ParseException {
    return typeProductService.findById(Long.parseLong(text));
  }

  @Override
  public String print(TypeProduct object, Locale locale) {
    return "[" + object.getId() + ", " +object.getName() + "]";
  }
}
