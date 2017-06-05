package com.springtraining.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


/**
 * The persistent class for the T_TIME database table.
 *
 */
@Entity
@Table(name="T_TIME")
@NamedQuery(name="TTime.findAll", query="SELECT t FROM TTime t")
public class TTime implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TTimePK id;

	@Column(name="BREAK_TIME")
	private BigDecimal breakTime;

	@Column(name="CREATE_DATE", updatable = false)
	private Timestamp createDate;

	@Column(name="CREATE_USER", updatable = false)
	private String createUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="END_DATE")
	private java.util.Date endDate;

	@Column(name="INVALID_FLG")
	private String invalidFlg;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="START_DATE")
	private java.util.Date startDate;

	@Column(name="UPDATE_DATE")
	private Timestamp updateDate;

	@Column(name="UPDATE_USER")
	private String updateUser;

	private String biko;

	//bi-directional many-to-one association to MUser
	@ManyToOne
	@JoinColumn(name="USER_ID", insertable=false, updatable=false)
	private MUser MUser;

	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name="ATTENDANCE_DATE", insertable=false, updatable=false)
	private Holiday holiday;

	public TTime() {
	}

	public TTimePK getId() {
		return this.id;
	}

	public void setId(TTimePK id) {
		this.id = id;
	}

	public BigDecimal getBreakTime() {
		return this.breakTime;
	}

	public void setBreakTime(BigDecimal breakTime) {
		this.breakTime = breakTime;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getInvalidFlg() {
		return this.invalidFlg;
	}

	public void setInvalidFlg(String invaildFlg) {
		this.invalidFlg = invaildFlg;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getBiko() {
		return biko;
	}

	public void setBiko(String biko) {
		this.biko = biko;
	}

	public MUser getMUser() {
		return this.MUser;
	}

	public void setMUser(MUser MUser) {
		this.MUser = MUser;
	}

	public Holiday getHoliday() {
		return this.holiday;
	}

	public void setHoliday(Holiday holiday) {
		this.holiday = holiday;
	}
}