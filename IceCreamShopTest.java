import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class IceCreamShopTest {

    @Test
    void testSingleScoopNoToppingsPaperCup() {
        Order order = new Order();
        IceCreamFlavor chocolate = new IceCreamFlavor("Chocolate Fudge", 3.00);

        order.addItem(new OrderItem(chocolate, 1));
        order.setWaffleCone(false);

        assertEquals(3.00, order.calculateSubtotal(), 0.01, "Subtotal should match");
        assertEquals(0.24, order.calculateTax(), 0.01, "Tax should match");
        assertEquals(3.24, order.calculateTotal(), 0.01, "Total should match");
    }




    @Test
    void testMultipleScoopsToppingsWaffleCone() {
        Order order = new Order();
        IceCreamFlavor mint = new IceCreamFlavor("Mint Chocolate Chip", 2.80);
        IceCreamFlavor strawberry = new IceCreamFlavor("Strawberry Swirl", 2.75);
        Topping sprinkles = new Topping("Sprinkles", 0.30);
        Topping strawberries = new Topping("Fresh Strawberries", 1.00);


        order.addItem(new OrderItem(mint, 2));
        order.addItem(new OrderItem(strawberry, 1));


        order.addTopping(sprinkles);
        order.addTopping(strawberries);
        order.setWaffleCone(true);

        assertEquals(12.65, order.calculateSubtotal(), 0.01, "Subtotal should match");
        assertEquals(1.01, order.calculateTax(), 0.01, "Tax should match");
        assertEquals(13.66, order.calculateTotal(), 0.01, "Total should match");
    }

    @Test
    void testNoScoopsOnlyToppings() {
        Order order = new Order();
        Topping marshmallow = new Topping("Marshmallow", 0.70);
        Topping chocChips = new Topping("Chocolate Chips", 0.50);


        order.addTopping(marshmallow);
        order.addTopping(chocChips);
        order.setWaffleCone(false);

        assertEquals(1.20, order.calculateSubtotal(), 0.01, "Subtotal should match");
        assertEquals(0.10, order.calculateTax(), 0.01, "Tax should match");
        assertEquals(1.30, order.calculateTotal(), 0.01, "Total should match");
    }

    @Test
    void testLargeOrderHighQuantities() {
        Order order = new Order();
        IceCreamFlavor pistachio = new IceCreamFlavor("Pistachio Delight", 3.25);
        IceCreamFlavor chocolate = new IceCreamFlavor("Chocolate Fudge", 3.00);
        Topping oreo = new Topping("Crushed Oreo", 0.85);
        Topping marshmallow = new Topping("Marshmallow", 0.70);


        order.addItem(new OrderItem(pistachio, 5));
        order.addItem(new OrderItem(chocolate, 3));

        order.addTopping(oreo);
        order.addTopping(oreo);
        order.addTopping(marshmallow);
        order.setWaffleCone(true);


        assertEquals(34.50, order.calculateSubtotal(), 0.01, "Subtotal should match");
        assertEquals(2.76, order.calculateTax(), 0.01, "Tax should match");
        assertEquals(37.26, order.calculateTotal(), 0.01, "Total should match");
    }

    @Test
    void testEmptyOrder() {
        Order order = new Order();


        assertEquals(0.00, order.calculateSubtotal(), 0.01, "Subtotal should be 0.00");
        assertEquals(0.00, order.calculateTax(), 0.01, "Tax should be 0.00");
        assertEquals(0.00, order.calculateTotal(), 0.01, "Total should be 0.00");
    }
}
