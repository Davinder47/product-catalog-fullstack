package com.ecom.productcatalog.repository;

import com.ecom.productcatalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //Why we used Product here because we are working with the Product Entity
    // Why Long because type of the Primary key is Long(which is id)

    List<Product> findByCategory(Long categoryId);
}
