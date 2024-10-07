package dao;

import dto.UserRequest;
import dto.UserResponse;
import Exception.UserOperationException;
import java.util.List;

public interface UserDAO {

    boolean createUser(UserRequest userRequest) throws UserOperationException;

    UserResponse getUserById(int id) throws UserOperationException;

    UserResponse getUserByEmail(String email) throws UserOperationException;

    boolean updateUser(UserRequest userRequest) throws UserOperationException;

    boolean deleteUserById(int id) throws UserOperationException;

    List<UserResponse> getAllUsers() throws UserOperationException;
    public boolean isValidUser(String username, String password) throws UserOperationException ;

}

