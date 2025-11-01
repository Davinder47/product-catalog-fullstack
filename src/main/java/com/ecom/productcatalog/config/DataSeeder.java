package com.ecom.productcatalog.config;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
//We need a piece of code to be executed immediately after the application started
//We will make use of CommandLineRunner(it's an interface which uses run method for doing this)
public class DataSeeder implements CommandLineRunner {

    //We will work with the DB, so we need Repositories
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    //run method is implemented by the CommandLineRunner interface
    //this method will contain all the code which we need to seed the
    //DB along with categories and products
    //This method will be executed when the App will start
    public void run(String... args) throws Exception {

        //When the App starts we need to:
        //1. Clear all existing data(includes preloaded or existing DB)
        //If you try to make any changes in workbench with data, below two
        //lines will remove those changes, and repopulate the data again
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        //2. Start Creating categories

        //First Category
        Category electronics = new Category();
        electronics.setName("Electronics");

        //Second Category
        Category clothing = new Category();
        clothing.setName("Clothing");

        //Third Category
        Category home = new Category();
        home.setName("Home and Kitchen");
        //Above categories are still objects in our java code,
        //they are not persisted in the DB yet
        //Persistence in a database is the ability of the system to store data permanently in
        //non-volatile storage, ensuring it remains available and intact even after the
        //application is closed or the system is shut down.

        //To persist Data into DB use repository:
        categoryRepository.saveAll(Arrays.asList(electronics,home,clothing));

        //3. Then Create Products
        //Product Name: Phone
        Product phone = new Product();
        phone.setName("SmartPhone");
        phone.setDescription("Latest mode smartphone with amazing features.");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(699.99);
        phone.setCategory(electronics);

        //Product Name: Laptop
        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("High performance laptop for work and gameplay.");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(999.99);
        laptop.setCategory(electronics);

        //Product Name: Jacket
        Product jacket = new Product();
        jacket.setName("Winter Jacket");
        jacket.setDescription("Comfortable and warm jacket, specialized for winters. ");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(99.99);
        jacket.setCategory(clothing);

        //Product Name: Blender
        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("High-speed blender for smoothies and shakes");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(89.99);
        blender.setCategory(home);

        //Now we need to save all the products, for this create Repo
        productRepository.saveAll(Arrays.asList(phone,laptop,jacket,blender));

    }
}
