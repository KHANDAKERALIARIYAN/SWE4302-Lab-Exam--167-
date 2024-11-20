import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Order {
    private List<OrderItem> items = new ArrayList<>();
    private List<Topping> toppings = new ArrayList<>();
    private boolean waffleCone;
    private static final double WAFFLE_CONE_PRICE = 5.00;
    private static final double TAX_RATE = 0.08;

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void setWaffleCone(boolean waffleCone) {
        this.waffleCone = waffleCone;
    }

    public double calculateSubtotal() {
        double subtotal = 0.0;
        for (OrderItem item : items) {
            subtotal += item.calculatePrice();
        }
        for (Topping topping : toppings) {
            subtotal += topping.getPrice();
        }
        if (waffleCone) {
            subtotal += WAFFLE_CONE_PRICE;
        }
        return subtotal;
    }

    public double calculateTax() {
        return calculateSubtotal() * TAX_RATE;
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }

    public void generateInvoice(String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Ice Cream Shop Invoice\n");
            writer.write("=======================\n");
            for (OrderItem item : items) {
                writer.write(item.getDescription() + "\n");
            }
            for (Topping topping : toppings) {
                writer.write(topping.getName() + ": $" + topping.getPrice() + "\n");
            }
            if (waffleCone) {
                writer.write("Waffle Cone: $" + WAFFLE_CONE_PRICE + "\n");
            }
            writer.write("Subtotal: $" + calculateSubtotal() + "\n");
            writer.write("Tax: $" + calculateTax() + "\n");
            writer.write("Total Amount Due: $" + calculateTotal() + "\n");
        }
    }
}