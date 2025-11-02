package com.example.product_service.web;


import com.example.product_service.DTO.ProductDTO;
import com.example.product_service.mappers.ProductMapper;
import com.example.product_service.models.ProductEntity;
import com.example.product_service.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@SuppressWarnings("unused")
@RestController
@CrossOrigin
@RequestMapping("/api/product")
public class ProductController {

    public final ProductRepository productRepository;

    public ProductController(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO) {
        ProductEntity product = ProductMapper.toEntity(productDTO);
        try {
            productRepository.save(product);
            return ResponseEntity.ok()
                    .body(Map.of("message","Product "+productDTO.getName()+" is saved !"));
        }catch(Exception e) {
            return ResponseEntity.status(500)
                    .body(Map.of("message","Server failed !"));
        }
    }

}
