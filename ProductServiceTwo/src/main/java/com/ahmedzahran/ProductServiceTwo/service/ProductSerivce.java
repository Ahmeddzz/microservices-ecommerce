package com.ahmedzahran.ProductServiceTwo.service;

import com.ahmedzahran.ProductServiceTwo.model.ProductRequest;
import com.ahmedzahran.ProductServiceTwo.model.ProductResponse;

public interface ProductSerivce {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long id);

    void reduceQuantity(Long productId, long quantity);
}
