class Lettuce extends SandwichDecorator {
    public Lettuce(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + ", Lettuce";
    }

    @Override
    public double getCost() {
        return sandwich.getCost() + 0.50;
    }
}