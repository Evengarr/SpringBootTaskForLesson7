package ru.geekbrains.springboottaskforlesson7.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.springboottaskforlesson7.exception.ResourceNotFoundException;
import ru.geekbrains.springboottaskforlesson7.model.Product;
import ru.geekbrains.springboottaskforlesson7.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServices {

    @Autowired
    private final ProductRepository repository;

    public ProductServices(ProductRepository repository) {
        this.repository = repository;
    }

    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Указанный продукт под номером " + id + " не обнаружент"));
    } // получение товара по Id

    public List<Product> findAllProducts() {
        return repository.findAll();
    } //получение списка продуктов

    public Product createProduct(Product product) {
        this.repository.save(product);
        return product;
    } // добавление продукта

    public void deleteProduct(Long id) {
        this.repository.deleteById(id);
    } // удаление продукта оп Id

    public Product findByTitle(String title) {
        return repository.findByTitle(title).orElseThrow(() ->new ResourceNotFoundException("Указанный продукт c названием " + title + " не обнаружент"));
    } // поиск по названию

    public List<Product> sortedProductByCost(Double min, Double max) {
        return repository.findAllByCostGreaterThanEqualAndCostLessThanEqual(min, max);
    } // сортировка продуктов по минимальной и максимальной цене

}

