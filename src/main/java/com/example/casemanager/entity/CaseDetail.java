package com.example.casemanager.entity;

import java.util.List;

import lombok.Data;

@Data
public class CaseDetail {
	private Integer caseId;
	private User user;
	private String caseName;
	private String clientName;
	private String detail;
	private Status status;
	private List<Task> taskList;
}
