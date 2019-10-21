package konkon.formatter;

import konkon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;

public class StringToLocalDateFormatter implements Formatter<LocalDate> {
  @Autowired
  private ProductService productService;
  @Autowired
  public StringToLocalDateFormatter(ProductService productService) {
    this.productService = productService;
  }
  @Override
  public LocalDate parse(String text, Locale locale) throws ParseException {
    return null;
  }

  @Override
  public String print(LocalDate object, Locale locale) {
    return null;
  }
}
