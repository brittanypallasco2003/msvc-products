package com.brittany.msvc.products.Product.infrastructure.adapters.output.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.brittany.msvc.products.Product.application.ports.output.ProductPersistencePort;
import com.brittany.msvc.products.Product.domain.model.Product;
import com.brittany.msvc.products.Product.infrastructure.adapters.input.rest.mapper.ProductDTOMapper;
import com.brittany.msvc.products.Product.infrastructure.adapters.output.persistence.entity.ProductEntity;
import com.brittany.msvc.products.Product.infrastructure.adapters.output.persistence.mapper.ProductPersistenceEntityMapper;
import com.brittany.msvc.products.Product.infrastructure.adapters.output.persistence.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProductPersistenceAdapter implements ProductPersistencePort {

    private final ProductRepository repository;
    private final ProductPersistenceEntityMapper entityMapper;

    public ProductPersistenceAdapter(ProductRepository repository, ProductPersistenceEntityMapper entityMapper,
            ProductDTOMapper dtoMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id)
                .map((productE) -> entityMapper.toDomain(productE));

    }

    @Override
    public List<Product> findAll() {
        return entityMapper.toListDomain(repository.findAll());
    }

    @Override
    public Product save(Product product) {
        log.info("Guardando producto en BD: {}", product.getId());
        ProductEntity entity=entityMapper.toEntity(product);
         log.info("Entidad a persistir: {}", entity.getId());
        ProductEntity saved=repository.save(entity);
        return entityMapper.toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
