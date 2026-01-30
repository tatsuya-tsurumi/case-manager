package com.example.casemanager.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRegistForm {
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String userName;
	
	@NotBlank
	private String password;
}
