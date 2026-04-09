package com.walmartapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity //representación de una tabla de BD en el código
@Data
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
}
