package Service;

import dao.CartDaoClass;
import dto.CartRequest;
import dto.CartResponse;

import java.util.List;

public class CartService {

    private final CartDaoClass cartDAO;

    public CartService() {
        cartDAO = new CartDaoClass();
    }

    public boolean addCart(CartRequest cartRequest) {
        try {
            boolean result = cartDAO.addCart(cartRequest);
            System.out.println("Add to cart operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error adding to cart: " + e.getMessage());
            return false;
        }
    }

    // New method to handle adding a product to the cart using userId and productId
    public void addCart(int userId, int productId) {
        CartRequest cartRequest = new CartRequest(userId, productId, 1); // Assuming default quantity as 1
        boolean result = addCart(cartRequest);
        if (result) {
            System.out.println("Product " + productId + " added to cart for user " + userId);
        } else {
            System.out.println("Failed to add product " + productId + " to cart for user " + userId);
        }
    }

    public CartResponse getCartById(int id) {
        try {
            CartResponse cart = cartDAO.getCartById(id);
            if (cart != null) {
                System.out.println("Fetched cart by ID: " + id);
            } else {
                System.out.println("No cart found with ID: " + id);
            }
            return cart;
        } catch (Exception e) {
            System.out.println("Error fetching cart by ID: " + e.getMessage());
            return null;
        }
    }

    public boolean updateCart(CartRequest cartRequest) {
        try {
            boolean result = cartDAO.updateCart(cartRequest);
            System.out.println("Update cart operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error updating cart: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteCartById(int id) {
        try {
            boolean result = cartDAO.deleteCartById(id);
            System.out.println("Delete cart operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error deleting cart: " + e.getMessage());
            return false;
        }
    }

    public List<CartResponse> getAllCarts() {
        try {
            List<CartResponse> carts = cartDAO.getAllCarts();
            if (!carts.isEmpty()) {
                System.out.println("Fetched all carts.");
            } else {
                System.out.println("No carts found.");
            }
            return carts;
        } catch (Exception e) {
            System.out.println("Error fetching all carts: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        // Create an instance of the CartService
        CartService service = new CartService();

        // Add a new cart item
        CartRequest newCart = new CartRequest(1, 1, 3);
        boolean isAdded = service.addCart(newCart);
        System.out.println("Cart addition status: " + isAdded);

        // Test the new addCart method
        service.addCart(1, 1);

        // Fetch a cart item by ID
        CartResponse cart = service.getCartById(6);
        if (cart != null) {
            System.out.println("Cart found: " + cart);
        } else {
            System.out.println("Cart with ID 1 not found.");
        }

        // Update a cart item
        CartRequest cartUpdate = new CartRequest(1, 2, 3, 9);
        boolean isUpdated = service.updateCart(cartUpdate);
        System.out.println("Cart update status: " + isUpdated);

        // Delete a cart item by ID
        boolean isDeleted = service.deleteCartById(5);
        System.out.println("Cart deletion status: " + isDeleted);

        // Fetch all cart items
        List<CartResponse> allCarts = service.getAllCarts();
        if (allCarts != null && !allCarts.isEmpty()) {
            allCarts.forEach(System.out::println);
        } else {
            System.out.println("No carts found.");
        }
    }
}
