package com.example.casemanager.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.casemanager.entity.Case;
import com.example.casemanager.entity.CaseSummary;

@Mapper
public interface CaseRepository {
	// 一覧全件検索
	List<CaseSummary> selectListAll();
	
	// ケース登録
	void insert(@Param("case") Case cases);
	
	// 条件検索
	List<CaseSummary> selectListByConditions(@Param("case") Case cases);
}
