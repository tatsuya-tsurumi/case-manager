package com.example.casemanager.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRegistForm {
	
	@NotBlank(message = "メールアドレスは必須です")
	@Email(message = "メールアドレスの形式が正しくありません")
	private String email;
	
	@NotBlank(message = "ユーザ名は必須です")
	private String userName;
	
	@NotBlank(message = "パスワードは必須です")
	private String password;
	
	@NotBlank(message = "確認用パスワードは必須です")
	private String confirmPassword;
}
