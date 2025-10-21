package com.brittany.msvc.products.Product.domain.exception;

public class ProductNotFoundException extends RuntimeException  {
    public ProductNotFoundException(String message){
        super(message);
    }

}
