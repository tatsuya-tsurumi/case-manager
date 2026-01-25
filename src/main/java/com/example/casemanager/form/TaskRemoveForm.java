package com.example.casemanager.form;

import java.sql.Date;

import lombok.Data;

@Data
public class TaskRemoveForm {
	private Integer taskId;
	private Integer caseId;
	private String title;
	private Date deadline;
	private String priorityCode;
	private String priorityName;
	private String statusCode;
	private String statusName;
}
