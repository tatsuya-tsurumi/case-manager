package com.example.casemanager.form;

import java.sql.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskRegistForm {
	private Integer caseId;
	
	@Size(min=1, max=64, message="1文字から64文字で指定してください")
	private String title;
	
	private Date deadline;
	
	@NotNull(message = "重要度を選択してください")
	@Size(min=1, message="重要度を選択してください")
	private String priorityCode;
	private String priorityName;
	
	@NotNull(message = "ステータスを選択してください")
	@Size(min=1, message="ステータスを選択してください")
	private String statusCode;
	private String statusName;
}
