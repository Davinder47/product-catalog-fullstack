package com.ecom.productcatalog.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity//To mark this class as Entity
@Data//To get all the getters and setters for this class
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//For auto generation of id
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;

    //To link this Entity to Category:
    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private Category category;
    //This category will be mapped/linked in Category Entity in Category class
    //via ManyToOne relationship
}
