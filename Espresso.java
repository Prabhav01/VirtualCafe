public class Espresso extends DrinkDecorator {
    public Espresso(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + "Espresso";
    }

    @Override
    public double getCost() {
        return drink.getCost() + 2.00;
    }
}
