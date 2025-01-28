package qa.udst.ecommerce.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PhysicalProduct extends BaseProduct implements Shippable {
    @Positive(message = "Weight must be positive")
    private double weight;

    public PhysicalProduct(String name, double price, double weight) {
        super(name, price, ProductCategory.PHYSICAL);
        this.weight = weight;
    }

    @Override
    public double calculateShippingCost() {
        return weight * 2;
    }

    @Override
    public String generateTrackingNumber() {
        return "TRACK-" + getName().hashCode();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Weight: " + weight + " kg");
    }
}