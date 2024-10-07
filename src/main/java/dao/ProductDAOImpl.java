package dao;

import dto.ProductRequest;
import dto.ProductResponse;
import Exception.ProductException;
import utils.ConnectionFactor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public ProductResponse getProductById(int id) throws ProductException  {
        String sql = "SELECT * FROM Products WHERE product_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ProductResponse(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getFloat("price"),
                        rs.getFloat("discounted_price"),
                        rs.getString("image_url"),
                        rs.getInt("category_id"),
                        rs.getInt("seller_id"),
                        rs.getInt("stock_quantity"),
                        rs.getInt("threshold_quantity")
                    );
                } else {
                    throw new ProductException("No product found with id: " + id);
                }
            }
        } catch (SQLException e) {
            throw new ProductException("Error fetching product with id: " + id, e);
        }
    }

    @Override
    public boolean createProduct(ProductRequest request) throws ProductException {
        String sql = "INSERT INTO Products (name, description, price, discounted_price, image_url, category_id, seller_id, stock_quantity, threshold_quantity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, request.getName());
            stmt.setString(2, request.getDescription());
            stmt.setDouble(3, request.getPrice());
            stmt.setDouble(4, request.getDiscountedPrice());
            stmt.setString(5, request.getImageUrl());
            stmt.setInt(6, request.getCategoryId());
            stmt.setInt(7, request.getSellerId());
            stmt.setInt(8, request.getStockQuantity());
            stmt.setInt(9, request.getThresholdQuantity());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                throw new ProductException("Product addition failed: " + request.getName());
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            throw new ProductException("Error adding product: " + request.getName(), e);
        }
    }

    @Override
    public boolean updateProduct(int productId, ProductRequest request) throws ProductException {
        String sql = "UPDATE Products SET name=?, description=?, price=?, discounted_price=?, image_url=?, category_id=?, seller_id=?, stock_quantity=?, threshold_quantity=? WHERE product_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, request.getName());
            stmt.setString(2, request.getDescription());
            stmt.setDouble(3, request.getPrice());
            stmt.setDouble(4, request.getDiscountedPrice());
            stmt.setString(5, request.getImageUrl());
            stmt.setInt(6, request.getCategoryId());
            stmt.setInt(7, request.getSellerId());
            stmt.setInt(8, request.getStockQuantity());
            stmt.setInt(9, request.getThresholdQuantity());
            stmt.setInt(10, request.getPrdouctid() );

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                throw new ProductException("Product update failed for ID: " + productId);
            }
        } catch (SQLException e) {
            throw new ProductException("Error updating product with ID: " + productId, e);
        }
    }

    @Override
    public boolean deleteProductById(int productId) throws ProductException {
        String sql = "DELETE FROM Products WHERE product_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, productId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                throw new ProductException("Product deletion failed for ID: " + productId);
            }
        } catch (SQLException e) {
            throw new ProductException("Error deleting product with ID: " + productId, e);
        }
    }

    @Override
    public List<ProductResponse> getAllProducts() throws ProductException {
        String sql = "SELECT * FROM Products";
        List<ProductResponse> products = new ArrayList<>();
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                products.add(new ProductResponse(
                    rs.getInt("product_id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getFloat("price"),
                    rs.getFloat("discounted_price"),
                    rs.getString("image_url"),
                    rs.getInt("category_id"),
                    rs.getInt("seller_id"),
                    rs.getInt("stock_quantity"),
                    rs.getInt("threshold_quantity")
                ));
            }
        } catch (SQLException e) {
            throw new ProductException("Error retrieving all products", e);
        }
        return products;
    }

    @Override
    public List<ProductResponse> getProductsByCategoryId(int categoryId) throws ProductException {
        String sql = "SELECT * FROM Products WHERE category_id=?";
        List<ProductResponse> products = new ArrayList<>();
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, categoryId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    products.add(new ProductResponse(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getFloat("price"),
                        rs.getFloat("discounted_price"),
                        rs.getString("image_url"),
                        rs.getInt("category_id"),
                        rs.getInt("seller_id"),
                        rs.getInt("stock_quantity"),
                        rs.getInt("threshold_quantity")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new ProductException("Error retrieving products by category ID: " + categoryId, e);
        }
        return products;
    }

    @Override
    public List<ProductResponse> getProductsBySellerId(int sellerId) throws ProductException {
        String sql = "SELECT * FROM Products WHERE seller_id=?";
        List<ProductResponse> products = new ArrayList<>();
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, sellerId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    products.add(new ProductResponse(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getFloat("price"),
                        rs.getFloat("discounted_price"),
                        rs.getString("image_url"),
                        rs.getInt("category_id"),
                        rs.getInt("seller_id"),
                        rs.getInt("stock_quantity"),
                        rs.getInt("threshold_quantity")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new ProductException("Error retrieving products by seller ID: " + sellerId, e);
        }
        return products;
    }

    @Override
    public List<ProductResponse> searchProductsByName(String name) throws ProductException {
    	String sql = "SELECT * FROM Products WHERE name LIKE ?";
        List<ProductResponse> products = new ArrayList<>();
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, "%" + name + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    products.add(new ProductResponse(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getFloat("price"),
                        rs.getFloat("discounted_price"),
                        rs.getString("image_url"),
                        rs.getInt("category_id"),
                        rs.getInt("seller_id"),
                        rs.getInt("stock_quantity"),
                        rs.getInt("threshold_quantity")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new ProductException("Error searching products by name: " + name, e);
        }
        return products;
    }

    @Override
    public List<ProductResponse> getProductsBelowThreshold() throws ProductException {
        String sql = "SELECT * FROM Products WHERE stock_quantity < threshold_quantity";
        List<ProductResponse> products = new ArrayList<>();
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                products.add(new ProductResponse(
                    rs.getInt("product_id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getFloat("price"),
                    rs.getFloat("discounted_price"),
                    rs.getString("image_url"),
                    rs.getInt("category_id"),
                    rs.getInt("seller_id"),
                    rs.getInt("stock_quantity"),
                    rs.getInt("threshold_quantity")
                ));
            }
        } catch (SQLException e) {
            throw new ProductException("Error retrieving products below threshold", e);
        }
        return products;
    }

    @Override
    public List<ProductResponse> getLowStockProducts() throws ProductException {
        String sql = "SELECT * FROM Products WHERE stock_quantity <= threshold_quantity";
        List<ProductResponse> products = new ArrayList<>();
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                products.add(new ProductResponse(
                    rs.getInt("product_id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getFloat("price"),
                    rs.getFloat("discounted_price"),
                    rs.getString("image_url"),
                    rs.getInt("category_id"),
                    rs.getInt("seller_id"),
                    rs.getInt("stock_quantity"),
                    rs.getInt("threshold_quantity")
                ));
            }
        } catch (SQLException e) {
            throw new ProductException("Error retrieving low stock products", e);
        }
        return products;
    }



  
   
}
