package dao;

import dto.SellerRequest;
import dto.SellerResponse;
import entity.Seller;
import Exception.SellerOperationException;
import utils.ConnectionFactor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class SellerDaoClass implements SellerDao {

    private static final Logger logger = LoggerFactory.getLogger(SellerDaoClass.class);

    @Override
    public SellerResponse getSellerById(int sellerId) throws SellerOperationException {
        String sql = "SELECT * FROM Sellers WHERE seller_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, sellerId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    logger.info("Seller found with id: {}", sellerId);
                    return new SellerResponse(
                        rs.getInt("seller_id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("business_name"),
                        rs.getString("business_details")
                    );
                }
            }
        } catch (SQLException e) {
            throw new SellerOperationException("Error fetching seller with id: " + sellerId, e);
        }
        logger.warn("No seller found with id: {}", sellerId);
        return null;
    }

    @Override
    public boolean createSeller(SellerRequest sellerRequest) throws SellerOperationException {
        String sql = "INSERT INTO Sellers (email, password, business_name, business_details) VALUES (?, ?, ?, ?)";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, sellerRequest.getEmail());
            stmt.setString(2, sellerRequest.getPassword());
            stmt.setString(3, sellerRequest.getBusinessName());
            stmt.setString(4, sellerRequest.getBusinessDetails());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Seller created successfully: {}", sellerRequest.getEmail());
                return true;
            }
        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                throw new SellerOperationException("Email already exists: " + sellerRequest.getEmail(), e);
            } else {
                throw new SellerOperationException("Error creating seller", e);
            }
        }
        return false;
    }

    @Override
    public boolean updateSeller(SellerRequest sellerRequest) throws SellerOperationException {
        String sql = "UPDATE Sellers SET email=?, password=?, business_name=?, business_details=? WHERE seller_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, sellerRequest.getEmail());
            stmt.setString(2, sellerRequest.getPassword());
            stmt.setString(3, sellerRequest.getBusinessName());
            stmt.setString(4, sellerRequest.getBusinessDetails());
            stmt.setInt(5, sellerRequest.getSellerId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Seller updated successfully: {}", sellerRequest.getSellerId());
                return true;
            }
        } catch (SQLException e) {
            throw new SellerOperationException("Error updating seller with id: " + sellerRequest.getSellerId(), e);
        }
        logger.warn("Seller update failed for id: {}", sellerRequest.getSellerId());
        return false;
    }

    @Override
    public boolean deleteSellerById(int id) throws SellerOperationException {
        String sql = "DELETE FROM Sellers WHERE seller_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Seller deleted successfully with id: {}", id);
                return true;
            }
        } catch (SQLException e) {
            throw new SellerOperationException("Error deleting seller with id: " + id, e);
        }
        logger.warn("Seller deletion failed for id: {}", id);
        return false;
    }

    @Override
    public List<SellerResponse> getAllSellers() throws SellerOperationException {
        String sql = "SELECT * FROM Sellers";
        List<SellerResponse> sellers = new ArrayList<>();
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                SellerResponse seller = new SellerResponse(
                    rs.getInt("seller_id"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("business_name"),
                    rs.getString("business_details")
                );
                sellers.add(seller);
            }
            logger.info("Fetched all sellers, count: {}", sellers.size());
        } catch (SQLException e) {
            throw new SellerOperationException("Error fetching all sellers", e);
        }
        return sellers;
    }

	

	public boolean isValidSeller(String email, String password) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM Sellers WHERE email = ? AND password = ?";
   	 try (Connection connection = ConnectionFactor.getConnectionFactor().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

           preparedStatement.setString(1, email);
           preparedStatement.setString(2, password);

           ResultSet resultSet = preparedStatement.executeQuery();

           return resultSet.next();
       } catch (SQLException e) {
           e.printStackTrace();
           return false;
       }
	}
}
