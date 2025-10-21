package com.brittany.msvc.products.Prueba.application.mapper;

import org.mapstruct.Mapper;

import com.brittany.msvc.products.Prueba.domain.Prueba;
import com.brittany.msvc.products.Prueba.application.dto.request.PruebaRequest;


@Mapper(componentModel = "spring")
public interface PruebaMapper {

    Prueba toEntity(PruebaRequest request);

}
