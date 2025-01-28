package qa.udst.ecommerce.model;

import lombok.*;
import java.util.ArrayList;

@Data
@NoArgsConstructor
public class Catalog {
    private ArrayList<BaseProduct> products = new ArrayList<>();

    public void addProduct(BaseProduct product) {
        this.products.add(product);
    }

    public void displayAllProducts() {
        for (BaseProduct product : products) {
            product.displayInfo();
        }
    }
}
