package com.example.casemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.casemanager.form.CaseRegistForm;




@Controller
public class CaseRegistController {
	/*-- ケース登録画面表示リクエスト --*/
	@PostMapping("/case-show-regist")
	public String showRegist(@ModelAttribute CaseRegistForm form) {
		return "case-regist";
	}
	
	/*-- ケース登録リクエスト(確認画面へ) --*/
	@PostMapping("/case-regist")
	public String regist(@Validated @ModelAttribute
			CaseRegistForm form, BindingResult result) {
		// 入力エラーがある場合、ケース登録画面に戻す
		if(result.hasErrors()) {
			return "case-regist";
		}
		// 正常な場合、確認画面へ遷移
		return "case-confirm-regist";
	}
	
	/*-- ケース登録リクエスト(実際に登録) --*/
	@PostMapping("/case-confirm-regist")
	public String confirmRegist(@Validated @ModelAttribute
			CaseRegistForm form, BindingResult result,
			RedirectAttributes redirectAttributes) {
		// 入力エラーがある場合、ケース登録画面に戻す
		if(result.hasErrors()) {
			return "case-regist";
		}
		
		// とりあえず記載
		System.out.println("登録フォーム");
		System.out.println(form);
		
		// フラッシュスコープにメッセージを格納して、リダイレクト　
		redirectAttributes.addFlashAttribute("msg", "タスク登録");
		
		return "redirect:case-complete";
	}
	
	
}
