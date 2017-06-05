package com.springtraining.repository;


import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springtraining.model.Holiday;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Date> {
	public Holiday findByTargetDate(Date targetDate);
}
