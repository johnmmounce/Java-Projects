import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private ArrayList<Product> Products;
    private ArrayList<Product> shoppingCart;

    public static void main(String[] args) {
        ArrayList<Product> Products = new ArrayList<>();
        ArrayList<Product> shoppingCart = new ArrayList<>();
        Taxed.setTaxRate(0.0825);

        Products.add(new Taxfree("Butter", 2.49));
        Products.add(new Taxfree("Fruit", 1.49));
        Products.add(new Taxfree("Bread", 3.99));
        Products.add(new Taxed("Chicken", 5.49));
        Products.add(new Taxed("Popcorn", 5.99));
        Products.add(new Taxed("Sponges", 2.99));
        Products.add(new Taxed("Chocolate", 2.99));
        
        Scanner input = new Scanner(System.in);
        
        int userInput = 0;

        while (userInput >= 0) {
        System.out.println("======================================");
        System.out.println("         Welcome to the Store         ");
        System.out.println("======================================");
        
            for (int i = 0; i < Products.size(); i++) {

                System.out.println(i + ") " + Products.get(i));
            }
         
            try {
                if (userInput >= 0) {
                    System.out.print("\n");
                    System.out.println("Current order");
                    System.out.println("-------------");
                    double sum = 0;
                    for (int j = 0; j < shoppingCart.size(); j++) {
                        System.out.println(shoppingCart.get(j));
                        sum += shoppingCart.get(j).Price();
                    }
                    String formattedSum = String.format("%.2f", sum);
                    System.out.print("Total price: $" + formattedSum + "\n");

                    System.out.println("Buy which product?");
                    userInput = input.nextInt();
                    Product temp = Products.get(userInput);
                    shoppingCart.add(temp);

                }
            } 
            catch (IndexOutOfBoundsException e) {
               System.err.println("input cannot be greater than the number of products");
            }
            catch (Exception e) {
                System.err.println("error: " + e.getMessage());
                System.exit(-234);
            }
        }
        input.close();
       // return 0;
    }

}