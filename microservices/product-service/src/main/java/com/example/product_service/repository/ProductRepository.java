package com.example.product_service.repository;


import com.example.product_service.models.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, String>,
        CrudRepository<ProductEntity, String>
{
    Optional<ProductEntity> findByProductId(int productId);
}
