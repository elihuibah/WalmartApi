package com.walmartapi.service;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.model.Product;
import com.walmartapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product saveProduct(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setDescription(product.getDescription());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());

        ProductEntity saveEntity = productRepository.save(productEntity);

        product.setName(saveEntity.getName());
        product.setDescription(saveEntity.getDescription());
        product.setPrice(saveEntity.getPrice());
        product.setId(saveEntity.getId());

        return product;
    }

}
