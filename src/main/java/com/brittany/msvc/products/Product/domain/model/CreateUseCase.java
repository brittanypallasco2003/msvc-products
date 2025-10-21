package com.brittany.msvc.products.domain.model;

import com.brittany.msvc.products.infrastructure.adapters.input.rest.dto.PruebaRequest;

public interface CreateUseCase {
    void execute(PruebaRequest request);
}
