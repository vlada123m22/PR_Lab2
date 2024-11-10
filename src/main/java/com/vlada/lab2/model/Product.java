package com.vlada.lab2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    private String name;
    private String price;
    private String characteristics;

    public String toString() {
        return "Product(name=" + this.getName() + ", price=" + this.getPrice() +  ", characteristics=" + this.getCharacteristics() + ")";
    }
}