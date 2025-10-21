package com.brittany.msvc.products.Prueba.application.service;

import org.springframework.grpc.server.service.GrpcService;

import com.brittany.msvc.products.Prueba.adapter.output.PruebaAdapter;
import com.brittany.msvc.products.Prueba.adapter.output.PruebaRepository;
import com.brittany.msvc.products.Prueba.domain.Prueba;
import com.example.prueba.PruebaRequest;
import com.example.prueba.PruebaResponse;
import com.example.prueba.PruebaServiceGrpc;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;

@GrpcService
@RequiredArgsConstructor
public class PruebaServiceGrpcImpl extends PruebaServiceGrpc.PruebaServiceImplBase {

    private final PruebaRepository pruebaRepository;

    @Override
    public void getPruebaByName(PruebaRequest request, StreamObserver<PruebaResponse> responseObserver){
        //request - db - map response - return
        String name=request.getName();
        Prueba entity=pruebaRepository.findByName(name);

        PruebaResponse pruebaResponse=PruebaResponse.newBuilder()
        .setName(name)
        .setRate(entity.getRate())
        .build();

        responseObserver.onNext(pruebaResponse);
        responseObserver.onCompleted();

    }
}
