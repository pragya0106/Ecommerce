package com.ecommerce.to;

public class UserTO {
	// we are going to initialize some basic variables for User Class which will act
	// as quite basic functionalities to our overall java program,
	// We are initializing them in TO class i.e. Transferrable objects.
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private String role;

	public UserTO() {

	}

	public UserTO(int id, String first_name, String last_name, String email, String password, String role) {
		this.email = email;
		this.id = id;
		this.setFirst_name(first_name);
		this.setLast_name(last_name);
		this.setPassword(password);
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
