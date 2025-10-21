package com.brittany.msvc.products.Product.infrastructure.adapters.input.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.brittany.msvc.products.Product.domain.exception.ProductNotFoundException;
import com.brittany.msvc.products.Product.infrastructure.adapters.input.rest.dto.ErrorResponseDTO;

import static com.brittany.msvc.products.Product.infrastructure.utils.ErrorCatalogEnum.GENERIC_ERROR;
import static com.brittany.msvc.products.Product.infrastructure.utils.ErrorCatalogEnum.INVALID_PRODUCT;
import static com.brittany.msvc.products.Product.infrastructure.utils.ErrorCatalogEnum.PRODUCT_NOT_FOUND;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleProductNotFoundExcepcion(ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDTO(PRODUCT_NOT_FOUND.getCode(),
                PRODUCT_NOT_FOUND.getMessage(), null, LocalDateTime.now()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        BindingResult result = ex.getBindingResult();
        List<String> details = result.getFieldErrors().stream()
                .map((fieldE) -> fieldE.getField() + " : " + fieldE.getDefaultMessage()).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDTO(INVALID_PRODUCT.getCode(),
                INVALID_PRODUCT.getMessage(), details, LocalDateTime.now()));

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDTO(GENERIC_ERROR.getCode(),
                GENERIC_ERROR.getMessage(), List.of(ex.getMessage()), LocalDateTime.now()));

    }

}
