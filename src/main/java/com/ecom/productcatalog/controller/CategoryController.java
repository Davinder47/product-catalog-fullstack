package com.ecom.productcatalog.controller;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
//In this controller we need an instance of service
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    //Below function will return list of all the categories
    public List<Category> getAllCategories(){
        //We need to interact with the DB first or fetch it, to do it:
        return categoryService.getAllCategories();
    }
}
