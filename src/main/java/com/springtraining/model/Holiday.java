package com.springtraining.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the HOLIDAY database table.
 *
 */
@Entity
@NamedQuery(name="Holiday.findAll", query="SELECT h FROM Holiday h")
public class Holiday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Temporal(TemporalType.DATE)
	@Column(name="TARGET_DATE")
	private java.util.Date targetDate;

	@Column(name="HOLIDAY_NAME")
	private String holidayName;

	//bi-directional many-to-one association to TTime
	@OneToMany(mappedBy="holiday")
	private List<TTime> TTimes;

	public Holiday() {
	}

	public java.util.Date getTargetDate() {
		return this.targetDate;
	}

	public void setTargetDate(java.util.Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getHolidayName() {
		return this.holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public List<TTime> getTTimes() {
		return this.TTimes;
	}

	public void setTTimes(List<TTime> TTimes) {
		this.TTimes = TTimes;
	}

	public TTime addTTime(TTime TTime) {
		getTTimes().add(TTime);
		TTime.setHoliday(this);

		return TTime;
	}

	public TTime removeTTime(TTime TTime) {
		getTTimes().remove(TTime);
		TTime.setHoliday(null);

		return TTime;
	}

}