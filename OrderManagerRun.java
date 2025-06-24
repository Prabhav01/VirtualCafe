public class OrderManagerRun {
    public static void main(String[] args) {
        OrderManager orderManager = OrderManager.getInstance();
        Sandwich sandwich = new BasicSandwich();
        sandwich = new ItalianBread(sandwich);
        sandwich = new Turkey(sandwich);
        sandwich = new Lettuce(sandwich);
        sandwich = new Provolone(sandwich);
        //create a drink
        Drink drink = new BasicDrink();
        drink = new Latte(drink);
        drink = new WhippedCream(drink);
        //create payment strategy
        PaymentStrategy paymentMethod = new CreditCardPayment("John pork", "1234-5678-9012-3456", "123", "12/25");
        Sandwich[] sandwiches = {sandwich};
        Drink[] drinks = {drink};
        int orderNumber = orderManager.processOrder(sandwiches, drinks, paymentMethod);
        System.out.println("Order processed with order number: "+orderNumber);
        Sandwich sandwich2 = new BasicSandwich();
        sandwich2 = new HoneyOat(sandwich2);
        sandwich2 = new Chicken(sandwich2);
        sandwich2 = new Bacon(sandwich2);

        Drink drink2 = new BasicDrink();
        drink2 = new HotChocolate(drink2);
        drink2 = new Marshmallows(drink2);

        PaymentStrategy paymentMethod2 = new CashPayment(50.00); // Paying with $50 bill

        Sandwich[] sandwiches2 = {sandwich2};
        Drink[] drinks2 = {drink2};
        int orderNumber2 = orderManager.processOrder(sandwiches2, drinks2, paymentMethod2);

        System.out.println("Second order processed with order number: " + orderNumber2);
    }
}
