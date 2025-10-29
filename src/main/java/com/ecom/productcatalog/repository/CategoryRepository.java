package com.ecom.productcatalog.repository;

import com.ecom.productcatalog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
//Category is the type of the Entity it is representing or its working with
//Long is the type of the primary key( 'id' which was Long in Category.java


}
