package com.brittany.msvc.products.application.ports.input;

import java.util.List;

import com.brittany.msvc.products.domain.model.Product;

public interface ProductServicePort {

    Product findById(Long id);

    List<Product> findAll();

    Product save(Product product);

    Product update(Long id, Product product);

    void deleteById(Long id);

}
