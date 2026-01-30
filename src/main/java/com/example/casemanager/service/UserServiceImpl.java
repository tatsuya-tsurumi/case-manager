package com.example.casemanager.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.casemanager.entity.User;
import com.example.casemanager.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncorder;
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		
		List<User> list = userRepository.selectAll();
		
		return list;
	}

	@Override
	@Transactional(readOnly=true)
	public User findById(String userId) {
		
		User user = userRepository.selectById(userId);
		
		return user;
	}

	@Override
	public void regist(User user) {
		
		user.setPassword(
			passwordEncorder.encode(user.getPassword())
		);
		userRepository.insert(user);
	}
	
	

}
