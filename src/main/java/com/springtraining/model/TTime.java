package com.springtraining.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


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

	@Column(name="CREATE_DATE")
	private Timestamp createDate;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="INVALID_FLG")
	private String invalidFlg;

	@Column(name="UPDATE_DATE")
	private Timestamp updateDate;

	@Column(name="UPDATE_USER")
	private String updateUser;

	//bi-directional many-to-one association to MUser
	@ManyToOne
	@JoinColumn(name="USER_ID", insertable=false, updatable=false)
	private MUser MUser;

	public TTime() {
	}

	public TTimePK getId() {
		return this.id;
	}

	public void setId(TTimePK id) {
		this.id = id;
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

	public String getInvalidFlg() {
		return this.invalidFlg;
	}

	public void setInvalidFlg(String invalidFlg) {
		this.invalidFlg = invalidFlg;
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

	public MUser getMUser() {
		return this.MUser;
	}

	public void setMUser(MUser MUser) {
		this.MUser = MUser;
	}

}