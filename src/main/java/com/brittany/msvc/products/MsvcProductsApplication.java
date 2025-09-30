package com.brittany.msvc.products;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brittany.msvc.products.infrastructure.adapters.output.persistence.entity.ProductEntity;
import com.brittany.msvc.products.infrastructure.adapters.output.persistence.repository.ProductRepository;

@SpringBootApplication
public class MsvcProductsApplication implements CommandLineRunner {

	private final ProductRepository repository;

	public MsvcProductsApplication(ProductRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MsvcProductsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<ProductEntity> entities = Arrays.asList(new ProductEntity(null, "Olla", 20.45, null, null),
				new ProductEntity(null, "Olla", 20.45, null, null),
				new ProductEntity(null, "Sartén", 10.45, null, null),
				new ProductEntity(null, "Cucharon", 1.23, null, null),
				new ProductEntity(null, "Set de cuchillos", 5.20, null, null));
		repository.saveAll(entities);

	}

}
