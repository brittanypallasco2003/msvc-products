package com.brittany.msvc.products.Prueba.adapter.output;

import java.util.Optional;

import com.brittany.msvc.products.Product.domain.Status;
import org.springframework.stereotype.Repository;

import com.brittany.msvc.products.Prueba.application.ports.ou.PruebaPersistence;
import com.brittany.msvc.products.Prueba.domain.Prueba;

import lombok.RequiredArgsConstructor;

@Repository 
@RequiredArgsConstructor
public class PruebaAdapter implements PruebaPersistence {
    private final PruebaRepository jPruebaRepository;

    @Override
    public Optional<Prueba> findById(Long id) {
        return jPruebaRepository.findById(id);
        
    }

    @Override
    public void save(Prueba entity) {
        jPruebaRepository.save(entity);

    }

    @Override
    public void delete(Prueba entity) {
        entity.setStatus(Status.DELETE);
        jPruebaRepository.save(entity);
    }

}
