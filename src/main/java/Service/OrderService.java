package Service;


import java.sql.Timestamp;
import java.util.List;
import dao.OrderDao;
import dao.OrderDaoClass;
import dto.OrderRequest;
import dto.OrderResponse;

public class OrderService {

    private final OrderDao orderDAO;

    public OrderService() {
        this.orderDAO = new OrderDaoClass();
    }

    // Add a new order
    public boolean createOrder(OrderRequest orderRequest) {
        try {
            boolean result = orderDAO.createOrder(orderRequest);
            System.out.println("Create order operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error creating order: " + e.getMessage());
            return false;
        }
    }

    // Get order by ID
    public OrderResponse getOrderById(int id) {
        try {
            OrderResponse order = orderDAO.getOrderById(id);
            if (order != null) {
                System.out.println("Fetched order by ID: " + id);
            } else {
                System.out.println("No order found with ID: " + id);
            }
            return order;
        } catch (Exception e) {
            System.out.println("Error fetching order by ID: " + e.getMessage());
            return null;
        }
    }

    // Get orders by buyer ID
    public List<OrderResponse> getOrdersByBuyerId(int userId) {
        try {
            List<OrderResponse> orders = orderDAO.getOrdersByBuyerId(userId);
            if (orders != null && !orders.isEmpty()) {
                System.out.println("Fetched orders for buyer ID: " + userId);
            } else {
                System.out.println("No orders found for buyer ID: " + userId);
            }
            return orders;
        } catch (Exception e) {
            System.out.println("Error fetching orders by buyer ID: " + e.getMessage());
            return null;
        }
    }

    // Update an existing order
    public boolean updateOrder(OrderRequest orderRequest) {
        try {
            boolean result = orderDAO.updateOrder(orderRequest);
            System.out.println("Update order operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error updating order: " + e.getMessage());
            return false;
        }
    }

    // Delete an order by ID
    public boolean deleteOrderById(int id) {
        try {
            boolean result = orderDAO.deleteOrderById(id);
            System.out.println("Delete order operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error deleting order: " + e.getMessage());
            return false;
        }
    }

    // Get all orders by product ID
    public List<OrderResponse> getAllOrdersByProductId(int productId) {
        try {
            List<OrderResponse> orders = orderDAO.getOrdersByProductId(productId);
            if (orders != null && !orders.isEmpty()) {
                System.out.println("Fetched all orders for product ID: " + productId);
            } else {
                System.out.println("No orders found for product ID: " + productId);
            }
            return orders;
        } catch (Exception e) {
            System.out.println("Error fetching all orders by product ID: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        // Create an instance of the OrderService
        OrderService service = new OrderService();

        // Create a new order
        OrderRequest newOrder = new OrderRequest(Double.valueOf(99.99), new Timestamp(System.currentTimeMillis()), "123 Shipping St", "456 Billing Ave", "Processing");
        boolean isCreated = service.createOrder(newOrder);
        System.out.println("Order creation status: " + isCreated);

        // Fetch an order by ID
        OrderResponse order = service.getOrderById(1);
        if (order != null) {
            System.out.println("Order found: " + order);
        } else {
            System.out.println("Order with ID 1 not found.");
        }

        // Fetch orders by buyer ID
        List<OrderResponse> ordersByBuyer = service.getOrdersByBuyerId(2);
        if (ordersByBuyer != null && !ordersByBuyer.isEmpty()) {
            ordersByBuyer.forEach(System.out::println);
        } else {
            System.out.println("No orders found for buyer ID 1.");
        }

        // Update an order
        OrderRequest orderUpdate = new OrderRequest(1, 1, Double.valueOf(89.99), new Timestamp(System.currentTimeMillis()), "123 Shipping St", "456 Billing Ave", "Shipped");
        boolean isUpdated = service.updateOrder(orderUpdate);
        System.out.println("Order update status: " + isUpdated);

        // Delete an order by ID
        boolean isDeleted = service.deleteOrderById(1);
        System.out.println("Order deletion status: " + isDeleted);

        // Fetch all orders by product ID
        List<OrderResponse> ordersByProduct = service.getAllOrdersByProductId(1);
        if (ordersByProduct != null && !ordersByProduct.isEmpty()) {
            ordersByProduct.forEach(System.out::println);
        } else {
            System.out.println("No orders found for product ID 1.");
        }
    }
}
