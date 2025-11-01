package com.example.recommendation_service.repository;

import com.example.recommendation_service.models.RecommendationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecommendationRepository extends CrudRepository<RecommendationEntity, String> {
    List<RecommendationEntity> findByProductId(int productId);
}
