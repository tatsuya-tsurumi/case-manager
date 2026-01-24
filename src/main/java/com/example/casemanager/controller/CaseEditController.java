package com.example.casemanager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.casemanager.entity.Case;
import com.example.casemanager.entity.Status;
import com.example.casemanager.entity.User;
import com.example.casemanager.form.CaseEditForm;
import com.example.casemanager.service.CaseService;
import com.example.casemanager.service.StatusService;
import com.example.casemanager.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CaseEditController {
	
	private final StatusService statusService;
	private final UserService userSerivce;
	private final CaseService caseService;
	
	/*-- ケース編集画面表示リクエスト --*/
	@PostMapping("/case-show-edit")
	public String showEdit(@ModelAttribute CaseEditForm form,
			Model model) {
		
		// ステータスリストを取得し、モデルに格納
		List<Status> list = statusService.findAll();
		model.addAttribute("statusList",list);
		
		// ユーザリストを取得し、モデルに格納
		List<User> userList = userSerivce.findAll();
		model.addAttribute("userList", userList);
		
		return "case-edit";
	}
	
	/*-- ケース編集リクエスト(確認画面へ) --*/
	@PostMapping("/case-edit")
	public String edit(@Validated @ModelAttribute
			CaseEditForm form, BindingResult result,
			Model model) {
		
		// 入力エラーがある場合、ケース編集画面に戻す
		if(result.hasErrors()) {
			
			// ステータスリストを取得し、モデルに格納
			List<Status> list = statusService.findAll();
			model.addAttribute("statusList",list);
			
			// ユーザリストを取得し、モデルに格納
			List<User> userList = userSerivce.findAll();
			model.addAttribute("userList", userList);
			
			return "case-edit";
		}
		
		// ステータス名をformに格納
		Status status = statusService.findByCode(form.getStatusCode());
		form.setStatusName(status.getStatusName());
		
		// ユーザ名をformに格納
		User user = userSerivce.findById(form.getUserId());
		form.setUserName(user.getUserName());
		
		// 正常な場合、確認画面へ遷移
		return "case-confirm-edit";
	}
	
	/*-- ケース編集リクエスト(実際に更新) --*/
	@PostMapping("/case-confirm-edit")
	public String confirmEdit(@Validated @ModelAttribute
			CaseEditForm form, BindingResult result,
			RedirectAttributes redirectAttributes,
			Model model) {
		// 入力エラーがある場合、ケース登録画面に戻す
		if(result.hasErrors()) {
			
			// ステータスリストを取得し、モデルに格納
			List<Status> list = statusService.findAll();
			model.addAttribute("statusList",list);
			
			// ユーザリストを取得し、モデルに格納
			List<User> userList = userSerivce.findAll();
			model.addAttribute("userList", userList);
			
			return "case-edit";
		}
		
		// form → entityへ
		Case cases = new Case();
		cases.setCaseId(form.getCaseId());
		cases.setUserId(form.getUserId());
		cases.setCaseName(form.getCaseName());
		cases.setClientName(form.getClientName());
		cases.setDetail(form.getDetail());
		cases.setStatusCode(form.getStatusCode());
		
		// とりあえず表示
		System.out.println("更新内容");
		System.out.println(cases);
		
		// フラッシュスコープにメッセージを格納して、リダイレクト　
		redirectAttributes.addFlashAttribute("msg", "ケース更新");
		
		return "redirect:case-complete";
	}
	
	
}
