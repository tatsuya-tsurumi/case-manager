package com.example.casemanager.service;

import java.util.List;

import com.example.casemanager.entity.Case;
import com.example.casemanager.entity.CaseDetail;
import com.example.casemanager.entity.CaseSummary;

public interface CaseService {
	// 一覧全件検索
	List<CaseSummary> findListAll();
	
	// 登録
	void regist(Case cases);
	
	// 条件検索
	List<CaseSummary> findListByConditions(Case cases);
	
	// 詳細検索
	CaseDetail findDetailByCaseId(Integer caseId);
	
	// 更新
	void edit(Case cases);
	
	// 削除
	void remove(Integer caseId);
}
