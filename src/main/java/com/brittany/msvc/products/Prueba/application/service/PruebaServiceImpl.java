package com.brittany.msvc.products.application.service;

import com.brittany.msvc.products.domain.DeleteUseCase;
import com.brittany.msvc.products.domain.Prueba;
import com.brittany.msvc.products.domain.model.CreateUseCase;
import com.brittany.msvc.products.infrastructure.adapters.input.rest.dto.PruebaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PruebaServiceImpl implements PruebaService{
    private final DeleteUseCase deleteUseCase;
    private final CreateUseCase createUseCase;

    @Override
    public void delete(Long id) {
        deleteUseCase.execute(id);
    }

    @Override
    public void save(PruebaRequest request) {
        createUseCase.execute(request);
    }
}
