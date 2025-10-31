package com.example.product_service.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.core.product.Product;
import se.magnus.api.core.product.ProductService;
import se.magnus.util.http.ServiceUtil;
@SuppressWarnings("unused")

@RestController
public class ProductServiceImpl implements ProductService {

    private final ServiceUtil serviceUtil;

    public ProductServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }


    @Override
    @GetMapping("/product/{productId}")
    public Product getProduct(@PathVariable int productId) {
        return new Product(productId, "name-" + productId, 123,
                serviceUtil.getServiceAddress());
    }
}
