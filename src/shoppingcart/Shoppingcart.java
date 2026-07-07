package shoppingcart;
import java.util.ArrayList;
import java.util.Iterator;
public class Shoppingcart {
    private ArrayList<CartItem> cart = new ArrayList<>();
    // Add item to cart
    public void addItem(Product product, int quantity) {
        for (CartItem item : cart) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                System.out.println("Quantity Updated Successfully.");
                return;
            }
        }
        cart.add(new CartItem(product, quantity));
        System.out.println("Product Added Successfully.");
    }
    // View cart
    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is Empty.");
            return;
        }
        double subtotal = 0;
        System.out.println("\n=========== CART ===========");
        for (CartItem item : cart) {
            System.out.println("Product ID : " + item.getProduct().getId());
            System.out.println("Product Name : " + item.getProduct().getName());
            System.out.println("Price : ₹" + item.getProduct().getPrice());
            System.out.println("Quantity : " + item.getQuantity());
            System.out.println("Total : ₹" + item.getTotalPrice());
            System.out.println("-----------------------------");
            subtotal += item.getTotalPrice();
        }
        System.out.println("Subtotal : ₹" + subtotal);
    }
    // Update quantity
    public void updateQuantity(int id, int quantity) {
        Iterator<CartItem> iterator = cart.iterator();
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            if (item.getProduct().getId() == id) {
                if (quantity <= 0) {
                    iterator.remove();
                    System.out.println("Product Removed Successfully.");
                } else {
                    item.setQuantity(quantity);
                    System.out.println("Quantity Updated Successfully.");
                }
                return;
            }
        }
        System.out.println("Product Not Found.");
    }
    // Remove item
    public void removeItem(int id) {
        Iterator<CartItem> iterator = cart.iterator();
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            if (item.getProduct().getId() == id) {
                iterator.remove();
                System.out.println("Product Removed Successfully.");
                return;
            }
        }
        System.out.println("Product Not Found.");
    }
    // Calculate subtotal
    public double calculateSubtotal() {
        double subtotal = 0;
        for (CartItem item : cart) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }
    // Total item quantity
    public int getTotalItems() {
        int totalItems = 0;
        for (CartItem item : cart) {
            totalItems += item.getQuantity();
        }
        return totalItems;
    }
    // Checkout
    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is Empty.");
            return;
        }
        double subtotal = calculateSubtotal();
        System.out.println("\n========== BILL ==========");
        for (CartItem item : cart) {
            System.out.println(item.getProduct().getName()
                    + " x " + item.getQuantity()
                    + " = ₹" + item.getTotalPrice());
        }
        System.out.println("--------------------------");
        System.out.println("Total Items : " + getTotalItems());
        System.out.println("Subtotal : ₹" + subtotal);
        cart.clear();
        System.out.println("--------------------------");
        System.out.println("Checkout Successful.");
        System.out.println("Cart Cleared.");
    }
}