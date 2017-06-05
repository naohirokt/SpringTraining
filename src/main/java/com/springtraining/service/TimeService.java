package com.springtraining.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtraining.model.TTime;
import com.springtraining.model.TTimePK;
import com.springtraining.repository.TTimeRepository;

@Service
public class TimeService {

	@Autowired
	private TTimeRepository timeRep;

	@Autowired
	private EntityManager entityManager;

	public List<TTime> getAll() {
		return timeRep.findAll();
	}

	public TTime getKey(TTimePK key) {
		return timeRep.findById(key);
	}

	public void save(TTime time) {
		timeRep.save(time);
	}

}
