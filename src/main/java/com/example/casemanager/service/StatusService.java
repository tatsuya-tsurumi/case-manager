package com.example.casemanager.service;

import java.util.List;

import com.example.casemanager.entity.Status;

public interface StatusService {
	
	// 一覧全件検索
	List<Status> findAll();
	
	// 1件取得
	Status findByCode(String statusCode);
}
