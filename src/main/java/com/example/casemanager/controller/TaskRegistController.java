package com.example.casemanager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.casemanager.entity.Priority;
import com.example.casemanager.entity.Status;
import com.example.casemanager.form.TaskRegistForm;
import com.example.casemanager.service.PriorityService;
import com.example.casemanager.service.StatusService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TaskRegistController {
	
	private final StatusService statusService;
	private final PriorityService priorityService;
	
	/*-- タスク登録画面表示リクエスト --*/
	@PostMapping("/task-show-regist")
	public String showRegist(@ModelAttribute TaskRegistForm form,
			Model model) {
		
		// ステータスリストを取得し、モデルに格納
		List<Status> list = statusService.findAll();
		model.addAttribute("statusList",list);
		
		// 重要度リストを取得し、モデルに格納
		List<Priority> priorityList = priorityService.findAll();
		model.addAttribute("priorityList",priorityList);
		
		return "task-regist";
	}
	
	/*-- タスク登録リクエスト(確認画面へ) --*/
	@PostMapping("/task-regist")
	public String regist(@Validated @ModelAttribute
			TaskRegistForm form, BindingResult result,
			Model model) {
		
		// 入力エラーがある場合、ケース登録画面に戻す
		if(result.hasErrors()) {
			
			// ステータスリストを取得し、モデルに格納
			List<Status> list = statusService.findAll();
			model.addAttribute("statusList",list);
			
			// 重要度リストを取得し、モデルに格納
			List<Priority> priorityList = priorityService.findAll();
			model.addAttribute("priorityList",priorityList);
			
			return "task-regist";
		}
		
		// ステータス名をformに格納
		Status status = statusService.findByCode(form.getStatusCode());
		form.setStatusName(status.getStatusName());
		
		// 重要度をformに格納
		Priority priority = priorityService.findByCode(form.getPriorityCode());
		form.setPriorityName(priority.getPriorityName());
				
		// 正常な場合、確認画面へ遷移
		return "task-confirm-regist";
	}
	
	/*-- タスク登録リクエスト(実際に登録) --*/
	@PostMapping("/task-confirm-regist")
	public String confirmRegist(@Validated @ModelAttribute
			TaskRegistForm form, BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		// 入力エラーがある場合、タスク登録画面に戻す
		if(result.hasErrors()) {
			return "task-regist";
		}
		
		// とりあえず表示
		System.out.println("タスク登録");
		System.out.println(form);
		
		// フラッシュスコープにメッセージを格納して、リダイレクト　
		redirectAttributes.addFlashAttribute("msg", "タスク登録");
		redirectAttributes.addFlashAttribute("caseId", form.getCaseId());
		
		return "redirect:task-complete";
	}
	
	
}
