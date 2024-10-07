package Service;

import dao.OrderItemDao;
import dao.OrderItemDaoClass;
import dto.OrderItemRequest;
import dto.OrderItemResponse;

import java.util.List;

public class OrderItemService {

    private final OrderItemDao orderItemDao;

    public OrderItemService() {
        this.orderItemDao = new  OrderItemDaoClass();
    }

    public boolean createOrderItem(OrderItemRequest orderItemRequest) {
        try {
            boolean result = orderItemDao.createOrderItem(orderItemRequest);
            System.out.println("Create order item operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error creating order item: " + e.getMessage());
            return false;
        }
    }

    public OrderItemResponse getOrderItemByOrderId(int orderId) {
        try {
            OrderItemResponse orderItem = orderItemDao.getOrderItemByOrderId(orderId);
            if (orderItem != null) {
                System.out.println("Fetched order item by order ID: " + orderId);
            } else {
                System.out.println("No order item found with order ID: " + orderId);
            }
            return orderItem;
        } catch (Exception e) {
            System.out.println("Error fetching order item by order ID: " + e.getMessage());
            return null;
        }
    }

    public List<OrderItemResponse> getOrderItemsByBuyerId(int buyerId) {
        try {
            List<OrderItemResponse> orderItems = orderItemDao.getOrderItemsByBuyerId(buyerId);
            if (!orderItems.isEmpty()) {
                System.out.println("Fetched order items by buyer ID: " + buyerId);
            } else {
                System.out.println("No order items found for buyer ID: " + buyerId);
            }
            return orderItems;
        } catch (Exception e) {
            System.out.println("Error fetching order items by buyer ID: " + e.getMessage());
            return null;
        }
    }

    public boolean updateOrderItem(OrderItemRequest orderItemRequest) {
        try {
            boolean result = orderItemDao.updateOrderItem(orderItemRequest);
            System.out.println("Update order item operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error updating order item: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteOrderItemById(int orderItemId) {
        try {
            boolean result = orderItemDao.deleteOrderItemById(orderItemId);
            System.out.println("Delete order item operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error deleting order item: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        // Example usage
        OrderItemService service = new OrderItemService();

        // Create a new order item
        OrderItemRequest newOrderItem = new OrderItemRequest(1, 2, 3,4,99.99);
        boolean isCreated = service.createOrderItem(newOrderItem);
        System.out.println("Order item creation status: " + isCreated);

        // Fetch an order item by order ID
        OrderItemResponse orderItem = service.getOrderItemByOrderId(1);
        if (orderItem != null) {
            System.out.println("Order item found: " + orderItem);
        } else {
            System.out.println("Order item with order ID 1 not found.");
        }

        // Update an order item
        OrderItemRequest orderItemUpdate = new OrderItemRequest(1, 2, 5,79.99);
        boolean isUpdated = service.updateOrderItem(orderItemUpdate);
        System.out.println("Order item update status: " + isUpdated);

        // Delete an order item by ID
        boolean isDeleted = service.deleteOrderItemById(1);
        System.out.println("Order item deletion status: " + isDeleted);
    }

	}

