package com.springtraining.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springtraining.model.TTime;
import com.springtraining.model.TTimePK;

@Repository
public interface TTimeRepository extends JpaRepository<TTime, String>{
	public TTime findById(TTimePK key);
}
