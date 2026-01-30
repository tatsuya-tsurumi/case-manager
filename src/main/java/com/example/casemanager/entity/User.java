package com.example.casemanager.entity;

import lombok.Data;

@Data
public class User {
	private Integer userId;
	private String email;
	private String userName;
	private String password;
	private boolean enabled; 
}
