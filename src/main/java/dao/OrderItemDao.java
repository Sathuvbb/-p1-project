package dao;

import dto.OrderItemRequest;
import dto.OrderItemResponse;
import Exception.OrderItemDaoException;
import java.util.List;

public interface OrderItemDao {
    boolean createOrderItem(OrderItemRequest request) throws OrderItemDaoException;
    OrderItemResponse getOrderItemByOrderId(int orderItemId) throws OrderItemDaoException;
    boolean updateOrderItem(OrderItemRequest request) throws OrderItemDaoException;
    boolean deleteOrderItemById(int orderItemId) throws OrderItemDaoException;
    List<OrderItemResponse> getOrderItemsByOrderId(int orderId) throws OrderItemDaoException;
    List<OrderItemResponse> getOrderItemsByBuyerId(int userId) throws OrderItemDaoException;
}
