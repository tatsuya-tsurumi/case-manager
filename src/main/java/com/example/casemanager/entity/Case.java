package com.example.casemanager.entity;

import lombok.Data;

@Data
public class Case {
	private Integer caseId;
	private String userId;
	private String caseName;
	private String clientName;
	private String detail;
	private String statusCode;
}
