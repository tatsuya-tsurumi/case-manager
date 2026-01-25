package com.example.casemanager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.casemanager.entity.Case;
import com.example.casemanager.entity.CaseDetail;
import com.example.casemanager.entity.CaseSummary;
import com.example.casemanager.repository.CaseRepository;
import com.example.casemanager.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CaseServiceImpl implements CaseService {
	
	private final CaseRepository caseRepository;
	private final TaskRepository taskRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<CaseSummary> findListAll() {
		
		List<CaseSummary> list = caseRepository.selectListAll();
		
		return list;
	}

	@Override
	@Transactional
	public void regist(Case cases) {
		caseRepository.insert(cases);
	}

	@Override
	public List<CaseSummary> findListByConditions(Case cases) {
		
		List<CaseSummary> list = caseRepository.selectListByConditions(cases);
		
		return list;
	}

	@Override
	public CaseDetail findDetailByCaseId(Integer caseId) {
		CaseDetail caseDetail = caseRepository.selectDetailByCaseId(caseId);
		return caseDetail;
	}

	@Override
	@Transactional
	public void edit(Case cases) {
		
		caseRepository.update(cases);
	}

	@Override
	@Transactional
	public void remove(Integer caseId) {
		// タスクIDを指定してタスク削除
		taskRepository.deleteByCaseId(caseId);
		
		// ケース削除
		caseRepository.delete(caseId);
	}


}
