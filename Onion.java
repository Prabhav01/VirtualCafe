class Onion extends SandwichDecorator {
    public Onion(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + ", Onion";
    }

    @Override
    public double getCost() {
        return sandwich.getCost() + 0.50;
    }
}
