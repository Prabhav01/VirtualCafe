public class Latte extends DrinkDecorator {
    public Latte(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + "Latte";
    }

    @Override
    public double getCost() {
        return drink.getCost() + 2.50;
    }
}
