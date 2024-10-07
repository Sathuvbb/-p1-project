package dao;

import dto.CartRequest;
import dto.CartResponse;
import Exception.CartDaoException;
import java.util.List;

public interface CartDao {
    boolean addCart(CartRequest cartRequest) throws CartDaoException;
    CartResponse getCartById(int id) throws CartDaoException;
    boolean updateCart(CartRequest cartRequest) throws CartDaoException;
    boolean deleteCartById(int id) throws CartDaoException;
    List<CartResponse> getAllCarts() throws CartDaoException;
	void addToCart(Integer userId, int productId) throws CartDaoException;
	void addToCart(int userId, int productId, int quantity) throws CartDaoException;
}
