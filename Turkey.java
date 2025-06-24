class Turkey extends SandwichDecorator {
    public Turkey(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription() + ", Turkey";
    }

    @Override
    public double getCost() {
        return sandwich.getCost() + 2.50;
    }
}