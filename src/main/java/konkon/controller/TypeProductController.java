package konkon.controller;

import konkon.model.TypeProduct;
import konkon.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TypeProductController {
  @Autowired
  TypeProductService typeProductService;
  @GetMapping("/typeProduct/list")
  public ModelAndView typeProductList(){
    Iterable<TypeProduct> typeProducts = typeProductService.findAll();
    ModelAndView modelAndView = new ModelAndView("/typeProduct/list");
    modelAndView.addObject("typeProducts", typeProducts);
    return modelAndView;
  }
}
