<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, java.util.*, jakarta.servlet.http.*, jakarta.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .profile-container {
            margin-top: 30px;
        }
        .card {
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        .btn-custom {
            background-color: #007bff;
            color: #fff;
            border-radius: 20px;
            padding: 10px 20px;
            border: none;
        }
        .btn-custom:hover {
            background-color: #0056b3;
        }
        .btn-danger-custom {
            background-color: #dc3545;
            color: #fff;
            border-radius: 20px;
            padding: 10px 20px;
            border: none;
        }
        .btn-danger-custom:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <div class="container profile-container">
        <h2 class="text-center">User Profile</h2>
        <div class="card">
            <div class="card-body">
                <%
                    // JDBC connection details
                    String jdbcURL = "jdbc:mysql://localhost:3306/your_database_name";
                    String dbUser = "your_db_username";
                    String dbPassword = "your_db_password";
                    
                    HttpSession session1 = request.getSession();
                    Integer userId = (Integer) session.getAttribute("userId"); // Fetch user ID from session
                    
                    if (userId != null) {
                        Connection connection = null;
                        PreparedStatement statement = null;
                        ResultSet resultSet = null;
                        
                        try {
                            // Load the database driver
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            
                            // Establish the connection
                            connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
                            
                            // SQL query to fetch user details
                            String sql = "SELECT name, password FROM Users WHERE user_id = ?";
                            statement = connection.prepareStatement(sql);
                            statement.setInt(1, userId);
                            
                            // Execute the query
                            resultSet = statement.executeQuery();
                            
                            // Process the result
                            if (resultSet.next()) {
                                String name = resultSet.getString("name");
                                String password = resultSet.getString("password");
                %>
                                <h5 class="card-title">Name: <%= name %></h5>
                                <p class="card-text">password: <%= password %></p>
                <%
                            } else {
                                out.println("User not found.");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            out.println("An error occurred while fetching user details.");
                        } finally {
                            // Close the resources
                            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
                            if (statement != null) try { statement.close(); } catch (SQLException e) { e.printStackTrace(); }
                            if (connection != null) try { connection.close(); } catch (SQLException e) { e.printStackTrace(); }
                        }
                    } else {
                        out.println("User not logged in.");
                    }
                %>
                <form action="updateProfile" method="post" style="display: inline;">
                    <input type="hidden" name="userId" value="<%= userId %>">
                    <button type="submit" class="btn btn-custom">Update Profile</button>
                </form>
                <form action="deleteProfile" method="post" style="display: inline;">
                    <input type="hidden" name="userId" value="<%= userId %>">
                    <button type="submit" class="btn btn-danger-custom" onclick="return confirm('Are you sure you want to delete your profile?');">Delete Account</button>
                </form>
            </div>
        </div>
    </div>

    <!-- Include Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
