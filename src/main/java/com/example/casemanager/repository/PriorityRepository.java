package com.example.casemanager.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.casemanager.entity.Priority;

@Mapper
public interface PriorityRepository {
	// 全件検索
	List<Priority> selectAll();
	
	// 1件検索
	Priority selectByCode(@Param("priorityCode") String priorityCode);
}
