package com.brittany.msvc.products.infrastructure.adapters.input.rest;

import com.brittany.msvc.products.application.service.PruebaService;
import com.brittany.msvc.products.infrastructure.adapters.input.rest.dto.PruebaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pruebas")
public class PruebaController {
    private final PruebaService service;

    @PostMapping
    public ResponseEntity<?>createJson(@RequestBody PruebaRequest request){
        service.save(request);
        return ResponseEntity.ok("Created entity");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
