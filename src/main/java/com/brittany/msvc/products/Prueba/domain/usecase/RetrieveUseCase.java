package com.brittany.msvc.products.Prueba.domain.usecase;

import com.brittany.msvc.products.Prueba.application.dto.response.PruebaResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface RetrieveUseCase {
Page<PruebaResponse> execute(Map<String, Object>params);
}
