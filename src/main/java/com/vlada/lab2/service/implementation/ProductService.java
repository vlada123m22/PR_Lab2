package com.vlada.lab2.service.implementation;

import com.vlada.lab2.dto.ProductDTO;
import com.vlada.lab2.model.Product;
import com.vlada.lab2.repository.ProductRepository;
import com.vlada.lab2.service.IProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getAllProducts(Pageable pageable) {
        return productRepository.getAllProducts(pageable);
    }

    @Override
    public ResponseEntity<String> deleteProduct(Long productId) {
        if (productRepository.existsById(productId)){
            productRepository.deleteById(productId);
            return ResponseEntity.ok("success");
        }
        return ResponseEntity.ok("fail");
    }

    @Override
    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setCharacteristics(productDTO.getCharacteristics());
        return productRepository.save(product);

    }
}
