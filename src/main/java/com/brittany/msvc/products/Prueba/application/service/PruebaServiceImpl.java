package com.brittany.msvc.products.Prueba.application.service;

import com.brittany.msvc.products.Prueba.domain.usecase.DeleteUseCase;
import com.brittany.msvc.products.Product.domain.model.CreateUseCase;
import com.brittany.msvc.products.Prueba.application.dto.request.PruebaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PruebaServiceImpl implements PruebaService {
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
