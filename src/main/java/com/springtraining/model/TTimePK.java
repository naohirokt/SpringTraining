package com.springtraining.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
			&& this.attendanceDate.equals(castOther.attendanceDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId.hashCode();
		hash = hash * prime + this.attendanceDate.hashCode();

		return hash;
	}
}