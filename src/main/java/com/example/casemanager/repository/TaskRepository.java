package com.example.casemanager.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.casemanager.entity.Task;

@Mapper
public interface TaskRepository {
	// タスク登録
	void insert(@Param("task") Task task);
	
	// タスク削除
	void delete(@Param("taskId") Integer taskId);
}
