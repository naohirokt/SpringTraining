package com.springtraining.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springtraining.model.TTime;

@Repository
public interface TTimeRepository extends JpaRepository<TTime, String>{
//	public List<TTime> findByMUserUserId(String userId);
}
