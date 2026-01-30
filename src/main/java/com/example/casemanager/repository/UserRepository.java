package com.example.casemanager.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.casemanager.entity.User;

@Mapper
public interface UserRepository {
	// 全件検索
	List<User> selectAll();
	
	// 1件検索
	User selectById(@Param("userId") String userId);
	
	// ユーザ登録処理
	void insert(User user);

	User selectByEmail(String email);
}
