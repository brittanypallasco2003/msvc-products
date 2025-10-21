package com.brittany.msvc.products.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brittany.msvc.products.application.ports.input.ProductServicePort;
import com.brittany.msvc.products.application.ports.output.ProductPersistencePort;
import com.brittany.msvc.products.domain.exception.ProductNotFoundException;
import com.brittany.msvc.products.domain.model.Product;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService implements ProductServicePort {

    private final ProductPersistencePort persistencePort;


    public ProductService(ProductPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public Product findById(Long id) {
        return persistencePort.findById(id).orElseThrow(()->new ProductNotFoundException("Producto no encontrado"));
       
    }

    @Override
    public List<Product> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Product save(Product product) {
        return persistencePort.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        return persistencePort
        .findById(id)
        .map(productDb-> {
            productDb.setName(product.getName());
            productDb.setPrice(product.getPrice());
            log.info("antes de guardar: {}",productDb.getId());
            return persistencePort.save(productDb);
        })
        .orElseThrow(()->new ProductNotFoundException("No se encontró el producto para su actualización"));
    }

    
    @Override
    public void deleteById(Long id) {
       if (persistencePort.findById(id).isEmpty()) {
        throw new ProductNotFoundException("Producto no encontrado");
       }
       persistencePort.deleteById(id); 
    }

}
