public class OrderManager {
    private static OrderManager instance;
    private int orderCounter;
    private double totalRevenue;
    private OrderManager(){
        orderCounter = 0;
        totalRevenue = 0.0;
    }
    public static synchronized OrderManager getInstance(){
        if(instance == null){
            instance = new OrderManager();
        }
        return instance;
    }
    public int processOrder(Sandwich[] sandwiches, Drink[] drinks, PaymentStrategy paymentStrategy) {
        double orderTotal = calculateOrderTotal(sandwiches, drinks);

        boolean paymentSuccessful = paymentStrategy.pay(orderTotal);

        if (paymentSuccessful) {
            orderCounter++;
            totalRevenue += orderTotal;
            System.out.println("Order #" + orderCounter + " processed successfully.");
            System.out.println("Order total: $" + String.format("%.2f", orderTotal));
            return orderCounter;
        } else {
            System.out.println("Payment processing failed. Order canceled.");
            return -1;
        }
    }
    private double calculateOrderTotal(Sandwich[] sandwiches, Drink[] drinks) {
        double total = 0.0;

        //calculate sandwich costs
        if (sandwiches != null) {
            for (Sandwich sandwich : sandwiches) {
                if (sandwich != null) {
                    total += sandwich.getCost();
                }
            }
        }
        //calculate drink costs
        if (drinks != null) {
            for (Drink drink : drinks) {
                if (drink != null) {
                    total += drink.getCost();
                }
            }
        }
        return total;
    }
    public int getOrderCount(){
        return orderCounter;
    }
    public double getTotalRevenue(){
        return totalRevenue;
    }
    public static void reset(){
        instance = null;
    }
}
