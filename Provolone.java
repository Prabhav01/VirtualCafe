class Provolone extends SandwichDecorator {
    public Provolone(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + ", Provolone Cheese";
    }

    @Override
    public double getCost() {
        return sandwich.getCost() + 1.00;
    }
}