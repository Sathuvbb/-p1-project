package dto;


public class UserResponse {
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int userId; 
	
	private String email;
    private String password;
    private String name;
	
 // Getters and Setters

public UserResponse(int userId, String email, String password, String name) {
		// TODO Auto-generated constructor stub
	super();
	this.userId = userId;
	this.email = email;
	this.password = password;
	this.name = name;
}
	

@Override
public String toString() {
	return "UserResponse [userId=" + userId + ", email=" + email + ", password=" + password + ", name=" + name+ "]";
}
}