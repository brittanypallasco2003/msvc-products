package com.brittany.msvc.products.infrastructure.adapters.input.rest;

import com.brittany.msvc.products.Prueba.application.service.PruebaServiceImpl;
import com.brittany.msvc.products.Product.domain.Status;
import com.brittany.msvc.products.Prueba.adapter.in.PruebaController;
import com.brittany.msvc.products.Prueba.application.dto.request.PruebaRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
class PruebaControllerTest {

    @Mock
    private PruebaServiceImpl pruebaService;

    @InjectMocks
    private PruebaController pruebaController;


    @Test
    void testCreateJsonShouldReturnOk(){
        //Given
        PruebaRequest request=new PruebaRequest(Status.ACTIVE);
        doNothing().when(pruebaService).save(request);

        //Act
        ResponseEntity<?>response=pruebaController.createJson(request);

        //Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals("Created entity",response.getBody());
    }

}