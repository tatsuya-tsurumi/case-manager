package com.example.casemanager.service;

import com.example.casemanager.entity.Task;

public interface TaskService {
	// タスク登録
	void regist(Task task);
	
	// タスク削除
	void remove(Integer taskId);
}
