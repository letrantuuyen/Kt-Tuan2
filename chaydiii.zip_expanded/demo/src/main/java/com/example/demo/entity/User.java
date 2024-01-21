package com.example.demo.entity;

public class User {
	
	private int userID;
	private String name;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userID, String name) {
		super();
		this.userID = userID;
		this.name = name;
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + "]";
	}
	

}
