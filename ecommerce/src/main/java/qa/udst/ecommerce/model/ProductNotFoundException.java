package qa.udst.ecommerce.model;

public class ProductNotFoundException  extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
