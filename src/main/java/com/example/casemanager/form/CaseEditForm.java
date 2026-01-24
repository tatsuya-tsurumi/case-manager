package com.example.casemanager.form;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CaseEditForm {
	private Integer caseId;
	private String userId;
	private String userName;
	@Size(min=1, max=32, message="1文字から32文字で指定してください")
	private String caseName;
	@Size(min=1, max=32, message="1文字から32文字で指定してください")
	private String clientName;
	private String detail;
	@Size(min=2, max=2, message="指定に誤りがあります")
	private String statusCode;
	private String statusName;
}
