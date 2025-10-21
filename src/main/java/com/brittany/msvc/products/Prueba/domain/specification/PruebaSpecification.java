package com.brittany.msvc.products.Prueba.domain.specification;

import com.brittany.msvc.products.Prueba.domain.Prueba;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

public class PruebaSpecification {
    private PruebaSpecification() {
        throw new IllegalStateException("Utility class");
    }


    public static Specification<Prueba>build(Map<String, Object> params){
     Specification<Prueba> spec= Specification.unrestricted();
        if (params.containsKey("status")) {
            String status = params.get("status").toString();
            spec = spec.and(statusContains(status));
        }
        return spec;
    }

    private static Specification<Prueba> statusContains(String status){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("status")), "%" + status.toLowerCase() + "%");
    }
}
