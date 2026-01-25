package com.example.casemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CommonController {
	/*-- 完了後のリダイレクト先(ケース完了系) --*/
	@GetMapping("/case-complete")
	public String completeCase() {
		return "case-complete";
	}
	
	/*-- 完了後のリダイレクト先(タスク完了系) --*/
	@GetMapping("/task-complete")
	public String completeTask() {
		return "task-complete";
	}
	
}
