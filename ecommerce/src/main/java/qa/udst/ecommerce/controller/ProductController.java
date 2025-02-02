package qa.udst.ecommerce.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qa.udst.ecommerce.model.*;
import qa.udst.ecommerce.service.ProductServices;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product", description = "Product management APIs")
public class ProductController {

    private final ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @Operation(summary = "Get all products", description = "Retrieves a list of all available products")
    @ApiResponse(responseCode = "200", description = "Products found",
            content = @Content(schema = @Schema(implementation = BaseProduct.class)))
    @GetMapping
    public ResponseEntity<List<BaseProduct>> getAllProducts() {
        return ResponseEntity.ok(productServices.getAllProducts());
    }

    @Operation(summary = "Get product by ID", description = "Retrieves a specific product by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Product found"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<BaseProduct> getProductById(@PathVariable Long id) {
        try {
            BaseProduct product = productServices.getProductById(id);
            return ResponseEntity.ok(product);
        } catch (ProductNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Create new product", description = "Creates a new product")
    @ApiResponse(responseCode = "200", description = "Product created successfully")
    @PostMapping
    public ResponseEntity<BaseProduct> createProduct(@Valid @RequestBody BaseProduct product) {
        Long id = productServices.addProduct(product);
        return ResponseEntity.ok(productServices.getProductById(id));
    }

    @Operation(summary = "Update product", description = "Updates an existing product by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Product updated successfully"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<BaseProduct> updateProduct(
            @PathVariable Long id, 
            @Valid @RequestBody BaseProduct product) {
        try {
            productServices.updateProduct(id, product);
            return ResponseEntity.ok(productServices.getProductById(id));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete product", description = "Deletes a product by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        try {
            productServices.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } catch (ProductNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Get product tracking info", description = "Retrieves tracking information for shippable products")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Tracking info retrieved successfully"),
        @ApiResponse(responseCode = "400", description = "Product is not shippable"),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping("/{id}/tracking")
    public ResponseEntity<TrackingInfo> getProductTracking(@PathVariable Long id) {
        try {
            BaseProduct product = productServices.getProductById(id);
            
            if (!(product instanceof Shippable)) {
                return ResponseEntity.badRequest().build();
            }

            Shippable shippableProduct = (Shippable) product;
            TrackingInfo trackingInfo = new TrackingInfo(
                shippableProduct.generateTrackingNumber(),
                shippableProduct.calculateShippingCost()
            );
            
            return ResponseEntity.ok(trackingInfo);
        } catch (ProductNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

@Schema(description = "Product tracking information")
class TrackingInfo {
    @Schema(description = "Tracking number for shipment")
    private String trackingNumber;
    
    @Schema(description = "Cost of shipping")
    private double shippingCost;

    public TrackingInfo(String trackingNumber, double shippingCost) {
        this.trackingNumber = trackingNumber;
        this.shippingCost = shippingCost;
    }

    // Getters and setters
    public String getTrackingNumber() { return trackingNumber; }
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }
    public double getShippingCost() { return shippingCost; }
    public void setShippingCost(double shippingCost) { this.shippingCost = shippingCost; }
}
