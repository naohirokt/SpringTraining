package com.springtraining.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtraining.model.Holiday;
import com.springtraining.repository.HolidayRepository;

@Service
public class HolidayService {

	@Autowired
	private HolidayRepository holidayRep;

	public List<Holiday> getHolidayAll() {
		return holidayRep.findAll();
	}

	public Holiday getTargetDay(Date targetDay) {
		return holidayRep.findByTargetDate(targetDay);
	}

}
