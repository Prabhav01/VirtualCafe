class HoneyOat extends SandwichDecorator {
    public HoneyOat(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + "Honey Oat";
    }

    @Override
    public double getCost() {
        return sandwich.getCost() + 1.00;
    }
}