package com.ionix.test.model;


import javax.persistence.*;

import java.io.Serializable;


@Entity
@Table(name="user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id", nullable=false)
    private Integer userId;

    @Column(name="name", nullable=false)
    private String name;
    
    @Column(name="username", nullable=false)
    private String username;

    @Column(name="email", nullable=false)
    private String email;
    
    @Column(name="phone", nullable=false)
    private String phone;

	public User() {
		super();
	}

	public User(Integer userId, String name, String username, String email, String phone) {
		super();
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.email = email;
		this.phone = phone;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
    
}
