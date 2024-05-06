package Projeto.ERP.ControllersModels;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Projeto.ERP.models.Product;
import Projeto.ERP.service.ProductService;
import util.CustomResponse;

@RestController
@RequestMapping(value = "/Products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> listProducts = productService.findAll();
        return ResponseEntity.ok().body(listProducts);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable UUID id) {
        Product product = productService.findById(id);
        return ResponseEntity.ok().body(product);
    }

    @PostMapping(value = "/NewProduct")
    public ResponseEntity<CustomResponse<Product>> newProduct(Product product) {
        productService.saveProduct(product);
        Date date = new Date();
        CustomResponse<Product> response = new CustomResponse<>(true, 201, "New Product added", date);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
