public class HotChocolate extends DrinkDecorator {
    public HotChocolate(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + "Hot Chocolate";
    }

    @Override
    public double getCost() {
        return drink.getCost() + 3.00;
    }
}
