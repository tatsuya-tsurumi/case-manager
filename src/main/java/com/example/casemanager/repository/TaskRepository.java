package com.example.casemanager.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.casemanager.entity.Task;

@Mapper
public interface TaskRepository {
	void insert(@Param("task") Task task);
}
