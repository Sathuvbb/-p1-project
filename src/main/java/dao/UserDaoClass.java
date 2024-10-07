package dao;

import dto.UserRequest;
import dto.UserResponse;
import entity.User;
import Exception.UserOperationException;
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

public class UserDaoClass implements UserDAO {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoClass.class);
	private String name;

    @Override
    public boolean createUser(UserRequest userRequest) throws UserOperationException {
        String sql = "INSERT INTO Users (email, password, name) VALUES (?, ?, ?)";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, userRequest.getEmail());
            stmt.setString(2, userRequest.getPassword());
            stmt.setString(3, userRequest.getName());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("User created successfully: {}", userRequest.getEmail());
                return true;
            }
        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                throw new UserOperationException("Email already exists: " + userRequest.getEmail(), e);
            } else {
                throw new UserOperationException("Error creating user", e);
            }
        }
        return false;
    }

    @Override
    public UserResponse getUserById(int id) throws UserOperationException {
        String sql = "SELECT * FROM Users WHERE user_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new UserResponse(
                        rs.getInt("user_id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            throw new UserOperationException("Error fetching user with id: " + id, e);
        }
        return null;
    }

    @Override
    public UserResponse getUserByEmail(String email) throws UserOperationException {
        String sql = "SELECT * FROM Users WHERE email=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new UserResponse(
                        rs.getInt("user_id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name")
                    );
                }
            }
        } catch (SQLException e) {
            throw new UserOperationException("Error fetching user with email: " + email, e);
        }
        return null;
    }

    @Override
    public boolean updateUser(UserRequest userRequest) throws UserOperationException {
        String sql = "UPDATE Users SET email=?, password=?, name=? WHERE user_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, userRequest.getEmail());
            stmt.setString(2, userRequest.getPassword());
            stmt.setString(3, userRequest.getName());
            stmt.setInt(4, userRequest.getUserId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("User updated successfully: {}", userRequest.getUserId());
                return true;
            }
        } catch (SQLException e) {
            throw new UserOperationException("Error updating user with id: " + userRequest.getUserId(), e);
        }
        return false;
    }

    @Override
    public boolean deleteUserById(int id) throws UserOperationException {
        String sql = "DELETE FROM Users WHERE user_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("User deleted successfully with id: {}", id);
                return true;
            }
        } catch (SQLException e) {
            throw new UserOperationException("Error deleting user with id: " + id, e);
        }
        return false;
    }

    @Override
    public List<UserResponse> getAllUsers() throws UserOperationException {
        String sql = "SELECT * FROM Users";
        List<UserResponse> users = new ArrayList<>();
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                UserResponse user = new UserResponse(
                    rs.getInt("user_id"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("name")
                );
                users.add(user);
            }
            logger.info("Fetched all users, count: {}", users.size());
            
        } catch (SQLException e) {
            throw new UserOperationException("Error fetching all users", e);
        }
        return users;
    }

    @Override
    public boolean isValidUser(String username, String password) {
        String query = "SELECT * FROM Users WHERE name = ? AND password = ?";
    	 try (Connection connection = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
