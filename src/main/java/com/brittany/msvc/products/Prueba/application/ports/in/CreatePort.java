package com.brittany.msvc.products.Prueba.application.ports.in;

import com.brittany.msvc.products.Prueba.application.ports.ou.PruebaPersistence;
import com.brittany.msvc.products.Product.domain.model.CreateUseCase;
import com.brittany.msvc.products.Prueba.application.dto.request.PruebaRequest;
import com.brittany.msvc.products.Prueba.application.mapper.PruebaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePort implements CreateUseCase {
    private final PruebaPersistence pruebaPersistence;
    private final PruebaMapper mapper;

    @Override
    public void execute(PruebaRequest request) {
        pruebaPersistence.save(mapper.toEntity(request));
    }
}
