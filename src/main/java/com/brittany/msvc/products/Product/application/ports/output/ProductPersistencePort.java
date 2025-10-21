package com.brittany.msvc.products.application.ports.output;

import java.util.List;
import java.util.Optional;

import com.brittany.msvc.products.domain.model.Product;

public interface ProductPersistencePort {

    Optional<Product> findById(Long id);
    List<Product> findAll();
    Product save(Product product);
    void deleteById(Long id);
    
}
