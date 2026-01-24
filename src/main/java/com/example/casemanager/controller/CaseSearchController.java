package com.example.casemanager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.casemanager.entity.CaseDetail;
import com.example.casemanager.entity.CaseSummary;
import com.example.casemanager.form.CaseSearchDetailForm;
import com.example.casemanager.service.CaseService;

import lombok.RequiredArgsConstructor;




@Controller
@RequiredArgsConstructor
public class CaseSearchController {
	
	private final CaseService caseService;
	
	/*-- 最初のリクエスト */
	@GetMapping("/top")
	public String showListSelection() {
		return "case-list";
	}
	
	/*-- 一覧検索リクエスト */
	@PostMapping("/case-search-list")
	public String searchList(Model model) {
		
		// 一覧の全件検索
		List<CaseSummary> list = caseService.findListAll();
		
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
