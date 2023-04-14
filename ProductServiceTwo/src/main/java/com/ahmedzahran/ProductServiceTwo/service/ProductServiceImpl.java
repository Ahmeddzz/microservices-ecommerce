package com.ahmedzahran.ProductServiceTwo.service;

import com.ahmedzahran.ProductServiceTwo.entity.Product;
import com.ahmedzahran.ProductServiceTwo.exception.ProductServiceCustomException;
import com.ahmedzahran.ProductServiceTwo.model.ProductRequest;
import com.ahmedzahran.ProductServiceTwo.model.ProductResponse;
import com.ahmedzahran.ProductServiceTwo.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductSerivce {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding product ...");

        Product product = Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity()).build();

        productRepository.save(product);
        log.info("Product with ID: " + product.getId() + " is created and successfully added to ProductRepository: productdb-two.");
        return product.getId();
    }

    @Override
    public ProductResponse getProductById(long id) {
        log.info("Get product with ID: {}", id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductServiceCustomException("Product with given ID not found","PRODUCT_NOT_FOUND"))     ;

        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;
    }

    @Override
    public void reduceQuantity(Long productId, long quantity) {

        log.info("Reduce quantity {} for Product with ID []", productId, quantity);

        Product product = productRepository.findById(productId)
                .orElseThrow( () -> new ProductServiceCustomException("Product with given ID not found","PRODUCT_NOT_FOUND"));

        if (product.getQuantity() < quantity){
            throw new ProductServiceCustomException("Product does not have sufficient QUANTITY","INSUFFICIENT_QUANTITY");
        }

        product.setQuantity(product.getQuantity()-quantity);
        productRepository.save(product);
        log.info("Product quantity updated Successfully!");

    }
}
