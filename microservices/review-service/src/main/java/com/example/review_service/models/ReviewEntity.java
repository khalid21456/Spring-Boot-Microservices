package com.example.review_service.models;

import io.netty.util.internal.SuppressJava6Requirement;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
@SuppressWarnings("unused")
@Entity
@Table(name = "reviews", indexes = { @Index(name = "reviews_unique_idx",
        unique = true, columnList = "productId,reviewId") })
public class ReviewEntity {

    @Id
    @GeneratedValue
    private int id;
    @Version
    private int version;
    private int productId;
    private int reviewId;
    private String author;
    private String subject;
    private String content;

}
