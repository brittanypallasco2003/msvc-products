package com.brittany.msvc.products.Product.infrastructure.adapters.input.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponseDTO(String code, String message, List<String> details, LocalDateTime timestamp) {

}
