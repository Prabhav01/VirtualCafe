class RoastBeef extends SandwichDecorator {
    public RoastBeef(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + ", Roast Beef";
    }

    @Override
    public double getCost() {
        return sandwich.getCost() + 2.50;
    }
}