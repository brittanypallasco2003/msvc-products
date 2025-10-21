package com.brittany.msvc.products.Prueba.application.ports.ou;

import java.util.Optional;

import com.brittany.msvc.products.Prueba.domain.Prueba;

public interface PruebaPersistence {
    Optional<Prueba> findById(Long id);
    void save(Prueba entity);
    void delete(Prueba entity);
}
