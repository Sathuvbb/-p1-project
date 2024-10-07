package Service;

import java.util.List;
import dao.UserDaoClass;
import dto.UserRequest;
import dto.UserResponse;

public class Userservice {

    private final UserDaoClass userdao;

    public Userservice() {
        userdao = new UserDaoClass();
    }

    public boolean createUser(UserRequest userRequest) {
        try {
        	
            boolean result = userdao.createUser(userRequest);
            System.out.println("Create user operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error creating user: " + e.getMessage());
            return false;
        }
    }

    public UserResponse getUserById(int id) {
        try {
        	
            UserResponse user = userdao.getUserById(id);
            if (user != null) {
                System.out.println("Fetched user by ID: " + id);
            } else {
                System.out.println("No user found with ID: " + id);
            }
            return user;
        } catch (Exception e) {
            System.out.println("Error fetching user by ID: " + e.getMessage());
            return null;
        }
    }

    public UserResponse getUserByEmail(String email) {
        try {
            UserResponse user = userdao.getUserByEmail(email);
            if (user != null) {
                System.out.println("Fetched user by email: " + email);
            } else {
                System.out.println("No user found with email: " + email);
            }
            return user;
        } catch (Exception e) {
            System.out.println("Error fetching user by email: " + e.getMessage());
            return null;
        }
    }

    public boolean updateUser(UserRequest userRequest) {
        try {
            boolean result = userdao.updateUser(userRequest);
            System.out.println("Update user operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error updating user: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteUserById(int id) {
        try {
            boolean result = userdao.deleteUserById(id);
            System.out.println("Delete user operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error deleting user: " + e.getMessage());
            return false;
        }
    }

    public List<UserResponse> getAllUsers() {
        try {
            List<UserResponse> users = userdao.getAllUsers();
            if (!users.isEmpty()) {
        //        System.out.println("Fetched all users."+ users);
            } else {
                System.out.println("No users found."+ users);
            }
            return users;
        } catch (Exception e) {
            System.out.println("Error fetching all users: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        // Create an instance of the Userservice
        Userservice service = new Userservice();

        // Fetch a user by ID
        UserResponse user = service.getUserById(1);
        if (user != null) {
            System.out.println(user.toString());
        } else {
            System.out.println("User not found.");
        }

        // Update a user
        UserRequest userUpdate = new UserRequest("newemail@example.com", "newpassword", "New Name", 1);
        boolean isUpdate = service.updateUser(userUpdate);
        System.out.println("User update status: " + isUpdate);

        // Create a new user
        UserRequest newUser = new UserRequest("saicharan@gmail.com", "saicharan1234", "charan");
        boolean isCreated = service.createUser(newUser);
        System.out.println("User creation status: " + isCreated);
        
        String emailToSearch = "newemail@example.com";  // Replace with the actual email you want to search for
        UserResponse userByEmail = service.getUserByEmail(emailToSearch);

        // Check and display the result
        if (userByEmail != null) {
            System.out.println("User found: " + userByEmail.toString());
        } else {
            System.out.println("User with email " + emailToSearch + " not found.");
        }

        // Delete a user by ID
        boolean isDeleted = service.deleteUserById(5);
        System.out.println("User deletion status: " + isDeleted);

        // Fetch all users
        List<UserResponse> allUsers = service.getAllUsers();
        if (allUsers != null && !allUsers.isEmpty()) {
            allUsers.forEach(System.out::println);
        } else {
            System.out.println("No users found.");
        }
    }
}
