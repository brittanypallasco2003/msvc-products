package com.brittany.msvc.products.application.ports.input;

import com.brittany.msvc.products.application.ports.output.PruebaPersistence;
import com.brittany.msvc.products.domain.model.CreateUseCase;
import com.brittany.msvc.products.infrastructure.adapters.input.rest.dto.PruebaRequest;
import com.brittany.msvc.products.infrastructure.adapters.output.persistence.mapper.PruebaMapper;
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
