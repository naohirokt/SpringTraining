package com.springtraining.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the T_TIME database table.
 * 
 */
@Embeddable
public class TTimePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="USER_ID")
	private String userId;

	@Temporal(TemporalType.DATE)
	@Column(name="ATTENDANCE_DATE")
	private java.util.Date attendanceDate;

	@Column(name="ATTENDANCE_TYPE")
	private String attendanceType;

	public TTimePK() {
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public java.util.Date getAttendanceDate() {
		return this.attendanceDate;
	}
	public void setAttendanceDate(java.util.Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public String getAttendanceType() {
		return this.attendanceType;
	}
	public void setAttendanceType(String attendanceType) {
		this.attendanceType = attendanceType;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TTimePK)) {
			return false;
		}
		TTimePK castOther = (TTimePK)other;
		return 
			this.userId.equals(castOther.userId)
			&& this.attendanceDate.equals(castOther.attendanceDate)
			&& this.attendanceType.equals(castOther.attendanceType);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId.hashCode();
		hash = hash * prime + this.attendanceDate.hashCode();
		hash = hash * prime + this.attendanceType.hashCode();
		
		return hash;
	}
}