package com.brittany.msvc.products.Prueba.application.service;

import com.brittany.msvc.products.Prueba.application.dto.request.PruebaRequest;

public interface PruebaService {
    void delete(Long id);
    void save(PruebaRequest request);
}
