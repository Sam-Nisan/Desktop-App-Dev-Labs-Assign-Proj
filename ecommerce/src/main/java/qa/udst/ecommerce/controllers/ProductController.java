package qa.udst.ecommerce.controllers;

import org.springframework.web.bind.annotation.*;
import qa.udst.ecommerce.model.BaseProduct;
import qa.udst.ecommerce.model.ProductCategory;

import qa.udst.ecommerce.services.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // GET: fetch all products
    private ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }
    @GetMapping("/all")
    public String getAllProducts() {

        return productServices.getDigitalProducts().toString();
        
        //return "All products fetched!";
    }

    // GET: fetch product by ID
    @GetMapping("/product")
    public String getProductById(@RequestParam int id) {
        return "Product fetched with ID: " + id;
    }

    // POST: create new product
    @PostMapping("/add")
    public String createProduct(@RequestBody BaseProduct product) {
        return "Product created: " + product.getName();
    }

    // PUT: update existing product
    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody BaseProduct product) {
        return "Product updated with ID: " + id;
    }

    // DELETE: remove product
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return "Product deleted with ID: " + id;
    }
}
