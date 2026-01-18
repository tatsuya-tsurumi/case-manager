package com.example.casemanager.form;

import lombok.Data;

@Data
public class CaseSearchListForm {
	private String userId;
	private String caseName;
	private String clientName;
	private String statusCode;
}
