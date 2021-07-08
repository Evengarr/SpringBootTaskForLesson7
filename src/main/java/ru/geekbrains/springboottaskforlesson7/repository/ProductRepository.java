package ru.geekbrains.springboottaskforlesson7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.springboottaskforlesson7.model.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByTitle(String title);

    List<Product> findAllByCostGreaterThanEqualAndCostLessThanEqual(double min, double max);
}
