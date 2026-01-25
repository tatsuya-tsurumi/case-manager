package com.example.casemanager.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.casemanager.entity.Task;

@Mapper
public interface TaskRepository {
	// タスク登録
	void insert(@Param("task") Task task);
	
	// タスク1件削除
	void delete(@Param("taskId") Integer taskId);
	
	// ケースIDを指定して削除
	void deleteByCaseId(@Param("caseId") Integer caseId);
}
