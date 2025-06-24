class Avocado extends SandwichDecorator {
    public Avocado(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + ", Avocado";
    }

    @Override
    public double getCost() {
        return sandwich.getCost() + 1.50;
    }
}