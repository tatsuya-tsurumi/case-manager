package com.example.casemanager.form;

import java.sql.Date;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskRegistForm {
	private Integer caseId;
	
	@Size(min=1, max=200, message="1文字から200文字で指定してください")
	private String title;
	
	private Date deadline;
	
	private String priorityCode;
	private String priorityName;
	
	private String statusCode;
	private String statusName;
}
