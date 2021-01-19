package onlinelibrary.business;

import java.io.Serializable;

public class Student implements Serializable {

	private String sid;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String salt;

	public Student() {
		username="";
		password="";
		email = "";
		firstName = "";
		lastName = "";
		setSalt("");
	}

	public Student(String sid, String username,String password,String firstName, String lastName, String email, String salt) {
		this.sid = sid;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", salt=" + salt + "]";
	}






}