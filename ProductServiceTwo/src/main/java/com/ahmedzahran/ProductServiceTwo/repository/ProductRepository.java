package com.ahmedzahran.ProductServiceTwo.repository;

import com.ahmedzahran.ProductServiceTwo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
