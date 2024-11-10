package com.vlada.lab2.repository;

import com.vlada.lab2.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {
    @Query(value = "SELECT p FROM  Product p")
    List<Product> getAllProducts(Pageable pageable);
}
