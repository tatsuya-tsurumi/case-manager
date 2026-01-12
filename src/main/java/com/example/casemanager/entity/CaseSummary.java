package com.example.casemanager.entity;

import lombok.Data;

@Data
public class CaseSummary {
	private Integer caseId;
	private String userId;
	private String caseName;
	private String clientName;
	private String status;
	private String detail;
}
