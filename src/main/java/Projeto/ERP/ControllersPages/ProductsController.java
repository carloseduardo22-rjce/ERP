package Projeto.ERP.ControllersPages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Projeto.ERP.models.Product;
import Projeto.ERP.service.ProductService;

@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "products")
    public String pageProducts() {
        return "tela-products/tela-products";
    }

    @GetMapping(value = "formProduct")
    public String pageFormProducts() {
        return "tela-products/formProduct";
    }

    @GetMapping(value = "listOfProducts")
    public String listOfProducts(Model model) {
        List<Product> list = productService.findAll();
        model.addAttribute("listOfProducts", list);
        return "views/products/listOfProducts";
    }

    @GetMapping(value = "removeProducts")
    public String removeProducts(Model model) {
        List<Product> list = productService.findAll();
        model.addAttribute("listOfProducts", list);
        return "views/products/removeProducts";
    }

}