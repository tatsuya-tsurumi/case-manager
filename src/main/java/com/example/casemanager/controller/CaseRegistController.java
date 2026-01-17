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
import com.example.casemanager.form.CaseRegistForm;
import com.example.casemanager.service.CaseService;
import com.example.casemanager.service.StatusService;
import com.example.casemanager.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CaseRegistController {
	
	private final StatusService statusService;
	private final UserService userSerivce;
	private final CaseService caseService;
	
	/*-- ケース登録画面表示リクエスト --*/
	@PostMapping("/case-show-regist")
	public String showRegist(@ModelAttribute CaseRegistForm form,
			Model model) {
		
		// ステータスリストを取得し、モデルに格納
		List<Status> list = statusService.findAll();
		model.addAttribute("statusList",list);
		
		// ユーザリストを取得し、モデルに格納
		List<User> userList = userSerivce.findAll();
		model.addAttribute("userList", userList);
		
		return "case-regist";
	}
	
	/*-- ケース登録リクエスト(確認画面へ) --*/
	@PostMapping("/case-regist")
	public String regist(@Validated @ModelAttribute
			CaseRegistForm form, BindingResult result,
			Model model) {
		
		// 入力エラーがある場合、ケース登録画面に戻す
		if(result.hasErrors()) {
			
			// ステータスリストを取得し、モデルに格納
			List<Status> list = statusService.findAll();
			model.addAttribute("statusList",list);
			
			// ユーザリストを取得し、モデルに格納
			List<User> userList = userSerivce.findAll();
			model.addAttribute("userList", userList);
			
			return "case-regist";
		}
		
		// ステータス名をformに格納
		Status status = statusService.findByCode(form.getStatusCode());
		form.setStatusName(status.getStatusName());
		
		// ユーザ名をformに格納
		User user = userSerivce.findById(form.getUserId());
		form.setUserName(user.getUserName());
		
		// 正常な場合、確認画面へ遷移
		return "case-confirm-regist";
	}
	
	/*-- ケース登録リクエスト(実際に登録) --*/
	@PostMapping("/case-confirm-regist")
	public String confirmRegist(@Validated @ModelAttribute
			CaseRegistForm form, BindingResult result,
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
			
			return "case-regist";
		}
		
		// form → entityへ
		Case cases = new Case();
		cases.setUserId(form.getUserId());
		cases.setCaseName(form.getCaseName());
		cases.setClientName(form.getClientName());
		cases.setDetail(form.getDetail());
		cases.setStatusCode(form.getStatusCode());
		
		caseService.regist(cases);
		
		// フラッシュスコープにメッセージを格納して、リダイレクト　
		redirectAttributes.addFlashAttribute("msg", "タスク登録");
		
		return "redirect:case-complete";
	}
	
	
}
