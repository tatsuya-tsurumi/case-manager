package com.example.casemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.casemanager.entity.Priority;
import com.example.casemanager.entity.Status;
import com.example.casemanager.form.TaskRemoveForm;
import com.example.casemanager.service.PriorityService;
import com.example.casemanager.service.StatusService;
import com.example.casemanager.service.TaskService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TaskRemoveController {
	
	private final StatusService statusService;
	private final PriorityService priorityService;
	private final TaskService taskService;
	
	/*-- タスク削除リクエスト(確認画面へ) --*/
	@PostMapping("/task-remove")
	public String remove(@ModelAttribute
			TaskRemoveForm form, Model model) {
		
		// ステータス名をformに格納
		Status status = statusService.findByCode(form.getStatusCode());
		form.setStatusName(status.getStatusName());
		
		// 重要度をformに格納
		Priority priority = priorityService.findByCode(form.getPriorityCode());
		form.setPriorityName(priority.getPriorityName());
				
		// 正常な場合、確認画面へ遷移
		return "task-confirm-remove";
	}
	
	/*-- タスク削除リクエスト(実際に登録) --*/
	@PostMapping("/task-confirm-remove")
	public String confirmRemove(@ModelAttribute
			TaskRemoveForm form, 
			RedirectAttributes redirectAttributes) {
		
		// とりあえず表示
		System.out.println("メモ削除");
		System.out.println(form);
		
		// フラッシュスコープにメッセージを格納して、リダイレクト　
		redirectAttributes.addFlashAttribute("msg", "タスク削除");
		redirectAttributes.addFlashAttribute("caseId", form.getCaseId());
		
		return "redirect:task-complete";
	}
	
	
}
