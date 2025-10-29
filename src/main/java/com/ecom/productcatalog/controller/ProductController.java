package com.ecom.productcatalog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    //We need two APIs/endpoints
    // 1. Which will help us to get all the products that exist in the DB
    // 2. Which will help us to get all the products that exists under a
    // particular category and that category will be filtered with the
    // help of Category id
    // For doing this we need to interact with and for that we need to
    // create a interface 'Product Repository'


}
