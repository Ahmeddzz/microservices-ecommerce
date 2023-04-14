package com.ahmedzahran.ProductServiceTwo.controller;

import com.ahmedzahran.ProductServiceTwo.model.ProductRequest;
import com.ahmedzahran.ProductServiceTwo.model.ProductResponse;
import com.ahmedzahran.ProductServiceTwo.service.ProductSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductSerivce productSerivce;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){

        long productId = productSerivce.addProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable long id){
        ProductResponse productResponse = productSerivce.getProductById(id);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable("id") Long productId, @RequestParam long quantity){
        productSerivce.reduceQuantity(productId, quantity);
return new ResponseEntity<>(HttpStatus.OK);
    }
}
