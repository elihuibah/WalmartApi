package com.walmartapi.service;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.exception.NotFound;
import com.walmartapi.mapper.CustomObjectMapper;
import com.walmartapi.model.Product;
import com.walmartapi.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CustomObjectMapper<ProductEntity, Product> productMapper;

    public ProductService(ProductRepository productRepository, CustomObjectMapper<ProductEntity, Product> productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Product getProductById(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);

        if(product.isEmpty()) {
            throw new NotFound("Product not found");
        }

        return productMapper.mapToDTO(product.get());
    }

    public Product saveProduct(Product product) { //Mapear objetos es crear objetos a partir de información de otros objetos
        ProductEntity newProduct = productMapper.mapToEntity(product);
        ProductEntity saveEntity = productRepository.save(newProduct); //Objeto que va a regresar la aplicación después de conectarse a la BD

        return productMapper.mapToDTO(saveEntity);
    }

    public Product updateProduct(Long id,  Product product) {
        getProductById(id);
        ProductEntity updateProduct = productMapper.mapToEntity(product);
        updateProduct.setId(id);
        ProductEntity updateEntity = productRepository.save(updateProduct);

        return productMapper.mapToDTO(updateEntity);
    }

    public void deleteProduct(Long id){
        getProductById(id);
        productRepository.deleteById(id);
    }

}