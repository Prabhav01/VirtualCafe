class Chicken extends SandwichDecorator {
    public Chicken(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + ", Chicken";
    }

    @Override
    public double getCost() {
        return sandwich.getCost() + 2.50;
    }
}