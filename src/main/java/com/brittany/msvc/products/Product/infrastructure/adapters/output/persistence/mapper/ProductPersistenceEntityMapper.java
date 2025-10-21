package com.brittany.msvc.products.Product.infrastructure.adapters.output.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.brittany.msvc.products.Product.domain.model.Product;
import com.brittany.msvc.products.Product.infrastructure.adapters.output.persistence.entity.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductPersistenceEntityMapper {
    
    ProductEntity toEntity(Product product);
    Product toDomain(ProductEntity productEntity);

    List<Product> toListDomain(List<ProductEntity> entityList);
    
}
