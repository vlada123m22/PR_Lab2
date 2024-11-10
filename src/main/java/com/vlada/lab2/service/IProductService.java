package com.vlada.lab2.service;


import com.vlada.lab2.dto.ProductDTO;
import com.vlada.lab2.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface IProductService {
    List<Product> getAllProducts(Pageable pageable);
    ResponseEntity<String> deleteProduct(Long productId);
    Product createProduct(ProductDTO productDTO);

}
