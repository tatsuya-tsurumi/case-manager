package com.example.casemanager.service;

import java.util.List;

import com.example.casemanager.entity.Priority;

public interface PriorityService {
	// 全件検索
	List<Priority> findAll();
	
	// 1件取得
	Priority findByCode(String priorityCode);
}
