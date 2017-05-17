package com.springtraining.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtraining.model.MUser;
import com.springtraining.repository.MUserRepository;

@Service
public class UserService {

	@Autowired
	private MUserRepository userRep;

	public List<MUser> getUserAll() {
		return userRep.findAll();
	}

	public MUser getUser(String userId) {
		return userRep.findByUserId(userId);
	}

	public MUser getUser(String userId, String password) {
		return userRep.findByUserIdAndPassword(userId, password);
	}

	public boolean existsUser(String userId) {
		return userRep.exists(userId);
	}

	public void save(MUser user) {
		userRep.save(user);
	}

	public void delete(String userId) {
		userRep.delete(userId);
	}
}
