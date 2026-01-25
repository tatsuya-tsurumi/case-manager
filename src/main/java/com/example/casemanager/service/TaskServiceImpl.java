package com.example.casemanager.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.casemanager.entity.Task;
import com.example.casemanager.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
	
	private final TaskRepository taskRepository;

	@Override
	@Transactional
	public void regist(Task task) {
		taskRepository.insert(task);
	}

	@Override
	@Transactional
	public void remove(Integer taskId) {
		taskRepository.delete(taskId);	
	}

}
