package com.example.casemanager.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.casemanager.entity.CaseSummary;

@Mapper
public interface CaseRepository {
	// 一覧全件検索
	List<CaseSummary> selectListAll();
}
