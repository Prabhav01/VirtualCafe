public class WhippedCream extends DrinkDecorator {
    public WhippedCream(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + ", Whipped Cream";
    }

    @Override
    public double getCost() {
        return drink.getCost() + 0.50;
    }
}
