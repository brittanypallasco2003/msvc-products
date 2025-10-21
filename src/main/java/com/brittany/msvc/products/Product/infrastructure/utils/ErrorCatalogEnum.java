package com.brittany.msvc.products.Product.infrastructure.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalogEnum {

    PRODUCT_NOT_FOUND("ERR_PRODUCT_001", "Product no encontrado"),
    INVALID_PRODUCT("ERR_PRODUCT_002", "Parámetros inválidos"),
    GENERIC_ERROR("ERR_GEN_001", "Error inesperado");

    private final String message;
    private final String code;

    ErrorCatalogEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
