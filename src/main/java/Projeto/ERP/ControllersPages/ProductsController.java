package Projeto.ERP.ControllersPages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {

    @GetMapping(value = "/products")
    public String pageProducts() {
        return "tela-products/tela-products";
    }

    @GetMapping(value = "formProduct")
    public String pageFormProducts() {
        return "tela-products/formProduct";
    }

}