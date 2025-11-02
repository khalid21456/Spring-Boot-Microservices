package com.example.product_service.mappers;

import com.example.product_service.DTO.ProductDTO;
import com.example.product_service.models.ProductEntity;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class ProductMapper {

    // Convert DTO → Entity
    public static ProductEntity toEntity(ProductDTO dto) {
        if (dto == null) {
            return null;
        }

        ProductEntity entity = new ProductEntity();
//        entity.setProductId(dto.getProductId());
        entity.setName(dto.getName());
        entity.setWeight(dto.getWeight());
        // Note: serviceAddress is not part of ProductEntity, so it's ignored.
        return entity;
    }

    // Convert Entity → DTO
    public static ProductDTO toDTO(ProductEntity entity) {
        if (entity == null) {
            return null;
        }

        ProductDTO dto = new ProductDTO();
        dto.setProductId(entity.getProductId());
        dto.setName(entity.getName());
        dto.setWeight(entity.getWeight());
        // serviceAddress is specific to the API layer, can be set separately
        dto.setServiceAddress(null);
        return dto;
    }
}
