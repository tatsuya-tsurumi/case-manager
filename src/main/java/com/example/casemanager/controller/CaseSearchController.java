package com.example.casemanager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.casemanager.entity.CaseSummary;
import com.example.casemanager.service.CaseService;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class CaseSearchController {
	
	private final CaseService caseService;
	
	/*-- 最初のリクエスト */
	@GetMapping("/top")
	public String showListSelection() {
		return "search-list";
	}
	
	/*-- 一覧検索リクエスト */
	@PostMapping("/case-search-list")
	public String searchList(Model model) {
		
		// 一覧の全件検索
		List<CaseSummary> list = caseService.findListAll();
		
		// 結果を格納してHTMLテンプレート名でreturn
		model.addAttribute("caseSummaryList", list);
		
		return "search-list";
	}
	
	
}
