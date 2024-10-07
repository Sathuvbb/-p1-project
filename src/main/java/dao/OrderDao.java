package dao;

import dto.OrderItemResponse;

import dto.OrderRequest;
import dto.OrderResponse;
import java.util.List;

import Exception.OrderDaoException;

public interface OrderDao {
    boolean createOrder(OrderRequest orderRequest) throws OrderDaoException;
    OrderResponse getOrderById(int id) throws OrderDaoException;
    List<OrderResponse> getOrdersByBuyerId(int buyerId) throws OrderDaoException;
    List<OrderResponse> getOrdersByProductId(int productId) throws OrderDaoException;
    boolean updateOrder(OrderRequest orderRequest) throws OrderDaoException;
    boolean deleteOrderById(int id) throws OrderDaoException;
    List<OrderResponse> getAllOrders() throws OrderDaoException;

}
