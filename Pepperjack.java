class Pepperjack extends SandwichDecorator {
    public Pepperjack(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + ", Pepperjack Cheese";
    }

    @Override
    public double getCost() {
        return sandwich.getCost() + 1.00;
    }
}