class Ham extends SandwichDecorator {
    public Ham(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + ", Ham";
    }

    @Override
    public double getCost() {
        return sandwich.getCost() + 2.50;
    }
}