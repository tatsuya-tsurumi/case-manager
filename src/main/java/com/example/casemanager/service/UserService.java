package com.example.casemanager.service;

import java.util.List;

import com.example.casemanager.entity.User;

public interface UserService {
	
	// 一覧全件検索
	List<User> findAll();
	
	// 1件検索
	User findById(String userId);
	
	// UserIdから1件検索
	User findByUserId(String userId);
	
	// ユーザ登録
	void regist(User user);
	
}
