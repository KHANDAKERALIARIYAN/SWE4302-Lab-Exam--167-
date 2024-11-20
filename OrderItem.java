class OrderItem {

    private IceCreamFlavor flavor;

    private int scoops;

    public OrderItem(IceCreamFlavor flavor, int scoops) {
        this.flavor = flavor;
        this.scoops = scoops;
    }

    public double calculatePrice() {
        return scoops * flavor.getPricePerScoop();
    }

    public String getDescription() {
        return flavor.getName() + " - " + scoops + " scoop(s): $" + calculatePrice();
    }
}