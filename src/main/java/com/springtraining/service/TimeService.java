package com.springtraining.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtraining.model.TTime;
import com.springtraining.repository.TTimeRepository;

@Service
public class TimeService {

	@Autowired
	private TTimeRepository timeRep;

	public List<TTime> getAll() {
		return timeRep.findAll();
	}

	public boolean existsUser(String userId, String type) {
		return timeRep.existsByUserIdAndAttendanceType(userId, type);
	}

	public void save(TTime time) {
		timeRep.save(time);
	}

}
