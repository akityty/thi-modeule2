package konkon.controller;

import konkon.model.Product;
import konkon.model.TypeProduct;
import konkon.service.ProductService;
import konkon.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
  @Autowired
  private TypeProductService typeProductService;
  @Autowired
  private ProductService productService;

  @ModelAttribute("typeProducts")
  public Iterable<TypeProduct> getAllTypeProduct() {
    return typeProductService.findAll();
  }

  @GetMapping("/product/list")
  public ModelAndView showListEmployee(@RequestParam("searchName") Optional<String> searchName) {
    List<Product> products;
    if (searchName.isPresent()) {
      products = productService.findAllByNameContaining(searchName.get());
    } else {
      products = productService.findAll();
    }
    ModelAndView modelAndView = new ModelAndView("/product/list");
    modelAndView.addObject("products", products);
    return modelAndView;
  }
  @GetMapping("/product/create")
  public String showCreateForm(Model model){
    model.addAttribute("product", new Product());
    return "/product/create";
  }
  @PostMapping("/product/create")
  public ModelAndView createProduct(@ModelAttribute Product product){
    ModelAndView modelAndView = new ModelAndView("redirect:/product/list");
    productService.save(product);
    modelAndView.addObject("product",product);
    return modelAndView;
  }
  @GetMapping("/product/edit/{id}")
  public ModelAndView showEditForm(@PathVariable Long id) {
    Product product = productService.findById(id);
    if (product != null) {
      ModelAndView modelAndView = new ModelAndView("/product/edit");
      modelAndView.addObject("product", product);
      return modelAndView;
    } else {
      return new ModelAndView("/error");
    }
  }

  @PostMapping("/product/edit")
  public ModelAndView editProduct(@ModelAttribute Product product) {
    productService.save(product);
    return new ModelAndView("redirect:/product/list");
  }
  @GetMapping("/product/delete/{id}")
  public ModelAndView showDelete(@PathVariable Long id) {
    Product product = productService.findById(id);
    if (product != null) {
      ModelAndView modelAndView = new ModelAndView("/product/delete");
      modelAndView.addObject("product", product);
      return modelAndView;
    } else {
      return new ModelAndView("/error");
    }
  }
  @PostMapping("/product/delete")
  public ModelAndView modelAndView(@ModelAttribute Product product){
    productService.delete(product);
    return new ModelAndView("redirect:/product/list");
  }
}
