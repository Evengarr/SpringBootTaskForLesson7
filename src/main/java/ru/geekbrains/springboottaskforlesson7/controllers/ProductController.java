package ru.geekbrains.springboottaskforlesson7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springboottaskforlesson7.model.Product;
import ru.geekbrains.springboottaskforlesson7.repository.ProductRepository;
import ru.geekbrains.springboottaskforlesson7.services.ProductServices;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    public ProductServices services;

    @Autowired
    public void setServices(ProductServices services) {
        this.services = services;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return services.findAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return services.findById(id);
    }

    @PostMapping("/add")
    public Product save(@RequestBody Product product) {
        return services.createProduct(product);
    }

    @GetMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id){
        this.services.deleteProduct(id);
    }

    @GetMapping("/sort_by_cost")
    public List<Product> sortByCost(@RequestParam Double min, @RequestParam Double max){
        return services.sortedProductByCost(min, max);
    }

    @GetMapping("/search_by_title")
    public Product findBiTitle(@RequestParam String title){
        return services.findByTitle(title);
    }
}
