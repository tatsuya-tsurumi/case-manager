package com.example.casemanager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.casemanager.entity.Case;
import com.example.casemanager.entity.CaseDetail;
import com.example.casemanager.entity.CaseSummary;
import com.example.casemanager.entity.Status;
import com.example.casemanager.entity.User;
import com.example.casemanager.form.CaseSearchDetailForm;
import com.example.casemanager.form.CaseSearchListForm;
import com.example.casemanager.service.CaseService;
import com.example.casemanager.service.StatusService;
import com.example.casemanager.service.UserService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class CaseSearchController {
	
	private final CaseService caseService;
	private final StatusService statusService;
	private final UserService userService;
	/*-- 最初のリクエスト */
	@GetMapping("/top")
	public String showListSelection(
			@ModelAttribute CaseSearchListForm form,
			Model model) {
		
		// ステータスリストをモデルに格納
		List<Status> statusList = statusService.findAll();
		model.addAttribute("statusList",statusList);
		
		// ユーザリストをモデルに格納
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		
		return "case-list";
	}
	public String showListSelection() {
		return "case-list";
	}
	
	/*-- 一覧検索リクエスト */
	@PostMapping("/case-search-list")
	public String searchList(
			@Validated @ModelAttribute CaseSearchListForm form,
			BindingResult result,
			Model model) {
		
		// form → entity
		Case cases = new Case();
		// userId設定
		if(!form.getUserId().equals("")) {
			cases.setUserId(form.getUserId());
		}
		// caseName設定
		if(!form.getCaseName().equals("")) {
			cases.setCaseName("%" + form.getCaseName() + "%");
		}
		// clientName設定
		if(!form.getClientName().equals("")) {
			cases.setClientName("%" + form.getClientName() + "%");
		}
		// statusCode設定
		if(!form.getStatusCode().equals("")) {
			cases.setStatusCode(form.getStatusCode());
		}
		System.out.println(cases);
		
		// 条件検索
		List<CaseSummary> list = caseService.findListByConditions(cases);
		
		// ステータスリストをモデルに格納(次回検索用)
		List<Status> statusList = statusService.findAll();
		model.addAttribute("statusList",statusList);
		
		// ユーザリストをモデルに格納(次回検索用)
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		
		// 結果を格納してHTMLテンプレート名でreturn
		model.addAttribute("caseSummaryList", list);
		
		return "case-list";
	}
	
	/*-- 詳細検索リクエスト --*/
	@PostMapping("/case-search-detail")
	public String searchDetail(CaseSearchDetailForm form,
					Model model) {
		
		// 詳細検索
		CaseDetail caseDetail = caseService.findDetailByCaseId(form.getCaseId());
		
		model.addAttribute("caseDetail", caseDetail);
		
		return "case-detail";
	}
	
	
	
}
