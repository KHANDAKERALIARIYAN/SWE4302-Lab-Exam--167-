import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class IceCreamShop {

    public static void main(String[] args) {

        IceCreamFlavor mint = new IceCreamFlavor("Mint Chocolate Chip", 2.80);
        IceCreamFlavor chocolate = new IceCreamFlavor("Chocolate Fudge", 3.00);
        IceCreamFlavor strawberry = new IceCreamFlavor("Strawberry Swirl", 2.75);
        IceCreamFlavor pistachio = new IceCreamFlavor("Pistachio Delight", 3.25);


        Topping sprinkles = new Topping("Sprinkles", 0.30);
        Topping marshmallow = new Topping("Marshmallow", 0.70);
        Topping oreo = new Topping("Crushed Oreo", 0.85);
        Topping strawberries = new Topping("Fresh Strawberries", 1.00);
        Topping chocChips = new Topping("Chocolate Chips", 0.50);


        Order order = new Order();
        order.addItem(new OrderItem(chocolate, 1));
        order.addItem(new OrderItem(mint, 1));
        order.addTopping(chocChips);
        order.addTopping(strawberries);
        order.setWaffleCone(true);


        try {
            order.generateInvoice("Invoice.txt");
            System.out.println("Invoice generated: Invoice.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
