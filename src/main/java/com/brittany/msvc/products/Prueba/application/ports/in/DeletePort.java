package com.brittany.msvc.products.Prueba.application.ports.in;

import org.springframework.stereotype.Service;

import com.brittany.msvc.products.Prueba.application.ports.ou.PruebaPersistence;
import com.brittany.msvc.products.Prueba.domain.usecase.DeleteUseCase;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeletePort implements DeleteUseCase {
    private final PruebaPersistence pruebaPersistence;
    @Override
    public void execute(Long id) {
       pruebaPersistence.findById(id).ifPresentOrElse(pruebaPersistence::delete
       , () -> { throw new EntityNotFoundException(); });
    }
    
}
