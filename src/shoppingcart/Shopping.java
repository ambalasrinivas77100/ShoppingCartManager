package shoppingcart;
import java.util.Scanner;
public class Shopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shoppingcart cart = new Shoppingcart();
        Product p1 = new Product(101, "Laptop", 55000);
        Product p2 = new Product(102, "Mouse", 600);
        Product p3 = new Product(103, "Keyboard", 1200);
        int choice;
        do {
            System.out.println("\n===== Shopping Cart =====");
            System.out.println("1. View Products");
            System.out.println("2. Add Item");
            System.out.println("3. View Cart");
            System.out.println("4. Update Quantity");
            System.out.println("5. Remove Item");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch (choice) {
            case 1:
                System.out.println("101 Laptop - ₹55000");
                System.out.println("102 Mouse - ₹600");
                System.out.println("103 Keyboard - ₹1200");
                break;
            case 2:
                System.out.print("Enter Product ID: ");
                int id = sc.nextInt();
                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();
                if (id == 101)
                    cart.addItem(p1, qty);
                else if (id == 102)
                    cart.addItem(p2, qty);
                else if (id == 103)
                    cart.addItem(p3, qty);
                else
                    System.out.println("Invalid Product ID");
                break;
            case 3:
                cart.viewCart();
                break;
            case 4:
                System.out.print("Enter Product ID: ");
                id = sc.nextInt();
                System.out.print("Enter New Quantity: ");
                qty = sc.nextInt();
                cart.updateQuantity(id, qty);
                break;
            case 5:
                System.out.print("Enter Product ID: ");
                id = sc.nextInt();
                cart.removeItem(id);
                break;
            case 6:
                cart.checkout();
                break;
            case 7:
                System.out.println("Thank You!");
                break;
            default:
                System.out.println("Invalid Choice");
            }
        } while (choice != 7);
        sc.close();
    }
}