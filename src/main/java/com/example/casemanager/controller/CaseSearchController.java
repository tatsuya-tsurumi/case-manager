package com.example.casemanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.casemanager.entity.CaseSummary;



@Controller
public class CaseSearchController {
	
	/*-- 最初のリクエスト */
	@GetMapping("/top")
	public String showListSelection() {
		return "search-list";
	}
	
	/*-- 一覧検索リクエスト */
	@PostMapping("/case-search-list")
	public String searchList(Model model) {
		
		// とりあえず作成
		List<CaseSummary> list = new ArrayList<CaseSummary>();
		CaseSummary c = new CaseSummary();
		c.setCaseId(1);
		c.setUserId("2");
		c.setCaseName("テスト");
		c.setClientName("ABC商事");
		c.setStatus("進行中");
		c.setDetail("詳細表示");
		list.add(c);
		
		// 結果を格納してHTMLテンプレート名でreturn
		model.addAttribute("caseSummaryList", list);
		
		return "search-list";
	}
	
	
}
