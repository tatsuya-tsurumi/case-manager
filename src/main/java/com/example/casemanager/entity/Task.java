package com.example.casemanager.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class Task {
	private Integer taskId;
	private Integer caseId;
	private String title;
	private Date deadline;
	private Priority priority;
	private Status status;
	private String priorityCode;
	private String statusCode;
}
