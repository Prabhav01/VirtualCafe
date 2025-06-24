class Bacon extends SandwichDecorator {
    public Bacon(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + ", Bacon";
    }

    @Override
    public double getCost() {
        return sandwich.getCost() + 2.00;
    }
}