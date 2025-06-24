import java.util.Scanner;

public class SandwichBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sandwich sandwich = new BasicSandwich();

        System.out.println("Welcome to the Sandwich Builder!");
        System.out.println("Choose your options below:");

        // Bread Options
        System.out.println("1. Multigrain Bread ($1.00)");
        System.out.println("2. Italian Bread ($1.00)");
        System.out.println("3. Honey Oat ($1.00)");
        System.out.println("4. Flatbread ($1.00)");
        System.out.print("Select your bread (1-4): ");
        int breadChoice = scanner.nextInt();
        if (breadChoice == 1) {
            sandwich = new MultigrainBread(sandwich);
        } else if (breadChoice == 2) {
            sandwich = new ItalianBread(sandwich);
        }else if (breadChoice == 3) {
            sandwich = new HoneyOat(sandwich);
        }else if (breadChoice == 4) {
            sandwich = new Flatbread(sandwich);
        }

        // Meat Options
        System.out.println("1. Turkey ($2.50)");
        System.out.println("2. Chicken ($2.50)");
        System.out.println("3. Roast Beef ($2.50)");
        System.out.println("4. Skip meat");
        System.out.print("Select your meat (1-4): ");
        int meatChoice = scanner.nextInt();
        if (meatChoice == 1) {
            sandwich = new Turkey(sandwich);
        }else if (meatChoice == 2) {
            sandwich = new Chicken(sandwich);
        }else if (meatChoice == 3) {
            sandwich = new RoastBeef(sandwich);
        }

        // Cheese Options
        System.out.println("1. Provolone Cheese ($1.00)");
        System.out.println("2. Pepper Jack ($1.00)");
        System.out.println("3. Skip Cheese");
        System.out.print("Select your cheese (1-3): ");
        int cheeseChoice = scanner.nextInt();
        if (cheeseChoice == 1) {
            sandwich = new Provolone(sandwich);
        }else if (cheeseChoice == 2) {
            sandwich = new Pepperjack(sandwich);
        }

        // Veggie Options
        System.out.println("1. Lettuce ($0.50)");
        System.out.println("2. Skip lettuce");
        System.out.print("Select Lettuce (1/2): ");
        int veggieChoice = scanner.nextInt();
        if (veggieChoice == 1) {
            sandwich = new Lettuce(sandwich);
        }

        System.out.println("1. Onion ($0.50)");
        System.out.println("2. Skip Onion");
        System.out.print("Select Onions (1/2): ");
         veggieChoice = scanner.nextInt();
        if (veggieChoice == 1) {
            sandwich = new Onion(sandwich);
        }

        // Extras
        System.out.println("1. Bacon ($2.00)");
        System.out.println("2. Skip bacon");
        System.out.print("Select extras (1/2): ");
        int extraChoice = scanner.nextInt();
        if (extraChoice == 1) {
            sandwich = new Bacon(sandwich);
        }

        // Final Sandwich
        System.out.println("\nYour Sandwich:");
        System.out.println("Description: " + sandwich.getDescription());
        System.out.println("Cost: $" + sandwich.getCost());

        scanner.close();
    }
}