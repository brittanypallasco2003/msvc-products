package com.brittany.msvc.products.Product.infrastructure.adapters.output.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private Double price;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @PrePersist
    public void createdAt(){
        this.createdAt=LocalDateTime.now();
    }

    @PreUpdate
    public void updatedAt(){
        this.updatedAt=LocalDateTime.now();
    }
}
