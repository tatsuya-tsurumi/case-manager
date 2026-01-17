package com.example.casemanager.service;

import java.util.List;

import com.example.casemanager.entity.User;

public interface UserService {
	
	// 一覧全件検索
	List<User> findAll();
	
	// 1件検索
	User findById(String userId);
	
}
