package com.example.casemanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.casemanager.entity.Priority;
import com.example.casemanager.repository.PriorityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriorityServiceImpl implements PriorityService {
	
	private final PriorityRepository priorityRepository;


	@Override
	public List<Priority> findAll() {
		List<Priority> list = priorityRepository.selectAll();
		return list;
	}


	@Override
	public Priority findByCode(String priorityCode) {
		
		Priority priority = priorityRepository.selectByCode(priorityCode);
		
		return priority;
	}

}
