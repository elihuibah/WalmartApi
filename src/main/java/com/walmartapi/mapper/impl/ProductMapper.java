package com.walmartapi.mapper.impl;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.mapper.CustomObjectMapper;
import com.walmartapi.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements CustomObjectMapper<ProductEntity, Product> {

    @Override
    public ProductEntity mapToEntity(Product dto) {
        // Product -> Entity
        ProductEntity productEntity = new ProductEntity();
        productEntity.setDescription(dto.getDescription());
        productEntity.setName(dto.getName());
        productEntity.setPrice(dto.getPrice());
        return productEntity;
    }

    @Override
    public Product mapToDTO(ProductEntity entity) {
        // Entity -> Product
        Product savedProduct = new Product();
        savedProduct.setName(entity.getName());
        savedProduct.setDescription(entity.getDescription());
        savedProduct.setPrice(entity.getPrice());
        savedProduct.setId(entity.getId());
        return savedProduct;
    }
}
