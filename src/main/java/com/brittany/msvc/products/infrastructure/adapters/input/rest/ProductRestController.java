package com.brittany.msvc.products.infrastructure.adapters.input.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brittany.msvc.products.application.ports.input.ProductServicePort;
import com.brittany.msvc.products.infrastructure.adapters.input.rest.dto.ProductRequestDTO;
import com.brittany.msvc.products.infrastructure.adapters.input.rest.dto.ProductResponseDTO;
import com.brittany.msvc.products.infrastructure.adapters.input.rest.mapper.ProductDTOMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductServicePort servicePort;
    private final ProductDTOMapper dtoMapper;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getProducts() {
        return ResponseEntity.ok().body(dtoMapper.toListResponse(servicePort.findAll()));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getMethodName(@PathVariable Long id) {
        return ResponseEntity.ok().body(dtoMapper.toResponse(servicePort.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> postProduct(@Valid @RequestBody ProductRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(dtoMapper.toResponse(servicePort.save(dtoMapper.toDomain(dto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(dtoMapper.toResponse(servicePort.update(id, dtoMapper.toDomain(dto))));
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        servicePort.deleteById(id);
    }

}
