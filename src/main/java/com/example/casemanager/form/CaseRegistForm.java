package com.example.casemanager.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CaseRegistForm {
	@NotNull(message = "ユーザを選択してください")
	private String userId;
	private String userName;
	@Size(min=1, max=32, message="1文字から32文字で指定してください")
	private String caseName;
	@Size(max=32, message="32文字以内で指定してください")
	private String clientName;
	private String detail;
	@NotNull(message = "ステータスを選択してください")
	private String statusCode;
	private String statusName;
}
