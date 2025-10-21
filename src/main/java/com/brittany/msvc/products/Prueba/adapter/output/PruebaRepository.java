package com.brittany.msvc.products.Prueba.adapter.output;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brittany.msvc.products.Prueba.domain.Prueba;


public interface PruebaRepository extends JpaRepository<Prueba, Long>{
    Prueba findByName(String name);

}
