package com.vlada.lab2.controler;

import com.vlada.lab2.dto.ProductDTO;
import com.vlada.lab2.model.Product;
import com.vlada.lab2.service.IProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@RestController
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService iProductService) {
        this.productService = iProductService;
    }

    @GetMapping("/products/{pageNr}/{elementsPerPage}")
    List<Product> getProducts(@PathVariable Integer pageNr, @PathVariable Integer elementsPerPage){
        Pageable pageable = PageRequest.of(pageNr,elementsPerPage);
        return productService.getAllProducts(pageable);
    }

    @DeleteMapping("/product/delete/{productId}")
    ResponseEntity<String> deleteProduct(@PathVariable Long productId){
        return productService.deleteProduct(productId);
    }

    @PutMapping("/product/create")
    ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO){

        if(Objects.nonNull(productDTO)){
            productService.createProduct(productDTO);
            return ResponseEntity.ok("success");
        }

        return ResponseEntity.ok("fail");
    }

}
