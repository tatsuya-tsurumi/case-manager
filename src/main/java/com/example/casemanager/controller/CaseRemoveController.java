package com.example.casemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.casemanager.entity.CaseDetail;
import com.example.casemanager.form.CaseRemoveForm;
import com.example.casemanager.service.CaseService;
import com.example.casemanager.service.PriorityService;
import com.example.casemanager.service.StatusService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CaseRemoveController {
	
	private final StatusService statusService;
	private final PriorityService priorityService;
	private final CaseService caseService;
	
	/*-- ケース削除リクエスト(確認画面へ) --*/
	@PostMapping("/case-remove")
	public String remove(@ModelAttribute
			CaseRemoveForm form, Model model) {
		
		CaseDetail caseDetail = caseService.findDetailByCaseId(form.getCaseId());
		model.addAttribute("caseDetail",caseDetail);
				
		// 正常な場合、確認画面へ遷移
		return "case-confirm-remove";
	}
	
	/*-- ケース削除リクエスト(実際に登録) --*/
	@PostMapping("/case-confirm-remove")
	public String confirmRemove(@ModelAttribute
			CaseRemoveForm form, 
			RedirectAttributes redirectAttributes) {
		
		// とりあえず表示
		System.out.println("ケース削除");
		System.out.println(form);
		
		// フラッシュスコープにメッセージを格納して、リダイレクト　
		redirectAttributes.addFlashAttribute("msg", "ケース削除");
		
		return "redirect:case-complete";
	}
	
	
}
