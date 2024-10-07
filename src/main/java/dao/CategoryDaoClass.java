package dao;

import dto.CategoryRequest;
import dto.CategoryResponse;
import Exception.CategoryDaoException;
import utils.ConnectionFactor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryDaoClass implements CategoryDao {

    private static final Logger logger = Logger.getLogger(CategoryDaoClass.class.getName());

    @Override
    public boolean createCategory(CategoryRequest categoryRequest) throws CategoryDaoException {
        String sql = "INSERT INTO Categories (name) VALUES (?)";
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, categoryRequest.getName());
            int rowsAffected = pstmt.executeUpdate();
            logger.info("Created category with name: " + categoryRequest.getName());
            return rowsAffected > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error creating category: " + e.getMessage(), e);
            throw new CategoryDaoException("Error creating category: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during category creation", e);
            throw new CategoryDaoException("Unexpected error during category creation", e);
        }
    }

    @Override
    public CategoryResponse getCategoryById(int id) throws CategoryDaoException {
        String sql = "SELECT * FROM Categories WHERE category_id = ?";
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new CategoryResponse(
                        rs.getInt("category_id"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching category by ID: " + id, e);
            throw new CategoryDaoException("Error fetching category by ID: " + id, e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during fetching category by ID", e);
            throw new CategoryDaoException("Unexpected error during fetching category by ID", e);
        }
        return null;
    }

    @Override
    public boolean updateCategory(CategoryRequest categoryRequest) throws CategoryDaoException {
        String sql = "UPDATE Categories SET name = ? WHERE category_id = ?";
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, categoryRequest.getName());
            pstmt.setInt(2, categoryRequest.getCategoryId());
            int rowsAffected = pstmt.executeUpdate();
            logger.info("Updated category with ID: " + categoryRequest.getCategoryId());
            return rowsAffected > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error updating category: " + e.getMessage(), e);
            throw new CategoryDaoException("Error updating category: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during category update", e);
            throw new CategoryDaoException("Unexpected error during category update", e);
        }
    }

    @Override
    public boolean deleteCategoryById(int id) throws CategoryDaoException {
        String sql = "DELETE FROM Categories WHERE category_id = ?";
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            logger.info("Deleted category with ID: " + id);
            return rowsAffected > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error deleting category: " + e.getMessage(), e);
            throw new CategoryDaoException("Error deleting category: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during category deletion", e);
            throw new CategoryDaoException("Unexpected error during category deletion", e);
        }
    }

    @Override
    public List<CategoryResponse> getAllCategories() throws CategoryDaoException {
        List<CategoryResponse> categories = new ArrayList<>();
        String sql = "SELECT * FROM Categories";
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                categories.add(new CategoryResponse(
                    rs.getInt("category_id"),
                    rs.getString("name")
                ));
            }
            logger.info("Fetched all categories.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching all categories: " + e.getMessage(), e);
            throw new CategoryDaoException("Error fetching all categories: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during fetching all categories", e);
            throw new CategoryDaoException("Unexpected error during fetching all categories", e);
        }
        return categories;
    }
}
