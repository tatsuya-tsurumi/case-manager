package com.example.casemanager.entity;

import lombok.Data;

@Data
public class CaseSummary {
	private Integer caseId;
	private User user;
	private String caseName;
	private String clientName;
	private String detail;
	private Status status;
	private Integer taskCnt;
}
