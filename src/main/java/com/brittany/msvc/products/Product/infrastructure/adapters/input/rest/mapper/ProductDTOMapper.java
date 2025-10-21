package com.brittany.msvc.products.Product.infrastructure.adapters.input.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.brittany.msvc.products.Product.domain.model.Product;
import com.brittany.msvc.products.Product.infrastructure.adapters.input.rest.dto.ProductRequestDTO;
import com.brittany.msvc.products.Product.infrastructure.adapters.input.rest.dto.ProductResponseDTO;

// ReportingPolicy.IGNORE: le dice a MapStruct que ignore los campos que no se puedan mapear en el destino.
// por ejemplo, si ProductRequestDTO no tiene un campo id, que si tiene Product, no genere un error de compilación. Simplementa ignora el campo no asociadao.
// Ignora campos que no se puedan maper con el destino
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductDTOMapper {
    // ignora el campo en el objeto destino (target) el campo id, ya que no viene en el objeto fuente (source) ProductRequestDTO
    //@Mapping(target = "id", ignore = true)
    // Request -> Domain
    Product toDomain(ProductRequestDTO requestDTO);

    // Domain -> Response
    ProductResponseDTO toResponse(Product product);

    List<ProductResponseDTO> toListResponse(List<Product> listProducts);

}
