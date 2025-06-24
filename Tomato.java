class Tomato extends SandwichDecorator {
    public Tomato(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + ", Tomato";
    }

    @Override
    public double getCost() {
        return sandwich.getCost() + 0.50;
    }
}