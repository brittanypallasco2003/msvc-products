package com.brittany.msvc.products.infrastructure.adapters.input.rest.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequestDTO(
        @NotBlank(message = "El campo no puedes ser nulo ni vació") String name,
        @NotNull(message = "El campo no puede ser nulo ni vació") @Digits(integer = 5, fraction = 2, message = "El precio debe tener dos decimales y un máximo de 5 dígitos enteros") @DecimalMin(value = "0.50") Double price) {
}
