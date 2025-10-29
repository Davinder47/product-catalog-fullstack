package com.ecom.productcatalog.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity//To mark this class as Entity
@Data//To get all the getters and setters for this class
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    //mappedBy category because in product class there was category
    //cascade will help when you will make changes in the Product.java, they will
    //also be reflected/cascaded in Category.java too
    private Set<Product> products;
    //Here we have id, name and products which have OneToMany relationship with Product Entity in Product class
}
