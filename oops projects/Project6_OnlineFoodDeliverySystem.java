/*
 Online Food Delivery System
 - Abstract FoodItem; VegItem and NonVegItem
 - Interface Discountable
*/
import java.util.*;

public class Project6_OnlineFoodDeliverySystem {
    public static abstract class FoodItem {
        private String itemName;
        private double price;
        private int quantity;

        public FoodItem(String itemName, double price, int quantity) {
            this.itemName = itemName;
            setPrice(price);
            setQuantity(quantity);
        }

        public String getItemName() { return itemName; }
        public double getPrice() { return price; }
        public int getQuantity() { return quantity; }

        public void setPrice(double price) {
            if (price < 0) throw new IllegalArgumentException("Negative price");
            this.price = price;
        }

        public void setQuantity(int quantity) {
            if (quantity < 0) throw new IllegalArgumentException("Negative qty");
            this.quantity = quantity;
        }

        public abstract double calculateTotalPrice();

        public String getItemDetails() {
            return itemName + " x" + quantity + " = " + calculateTotalPrice();
        }
    }

    public interface Discountable {
        void applyDiscount(double percent);
        String getDiscountDetails();
    }

    public static class VegItem extends FoodItem implements Discountable {
        private double discountPercent = 0.0;

        public VegItem(String name, double price, int qty) { super(name, price, qty); }

        @Override
        public double calculateTotalPrice() {
            double total = getPrice() * getQuantity();
            return total - total * (discountPercent/100.0);
        }

        @Override
        public void applyDiscount(double percent) { this.discountPercent = percent; }

        @Override
        public String getDiscountDetails() { return "Veg discount: " + discountPercent + "%"; }
    }

    public static class NonVegItem extends FoodItem implements Discountable {
        private double extraCharge = 20.0; // e.g., additional handling per item
        private double discountPercent = 0.0;

        public NonVegItem(String name, double price, int qty) { super(name, price, qty); }

        @Override
        public double calculateTotalPrice() {
            double total = (getPrice() + extraCharge) * getQuantity();
            return total - total * (discountPercent/100.0);
        }

        @Override
        public void applyDiscount(double percent) { this.discountPercent = percent; }

        @Override
        public String getDiscountDetails() { return "Non-veg discount: " + discountPercent + "%, extraCharge: " + extraCharge; }
    }

    public static void main(String[] args) {
        List<FoodItem> order = Arrays.asList(
            new VegItem("Paneer Tikka",200,2),
            new NonVegItem("Chicken Biryani",250,1)
        );

        // apply discounts via interface where available
        for (FoodItem f : order) {
            if (f instanceof Discountable) {
                ((Discountable)f).applyDiscount(10.0);
                System.out.println(((Discountable)f).getDiscountDetails());
            }
            System.out.println(f.getItemDetails());
        }
    }
}
