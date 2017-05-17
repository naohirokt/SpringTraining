package com.springtraining.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the M_USER database table.
 *
 */
@Entity
@Table(name="M_USER")
@NamedQuery(name="MUser.findAll", query="SELECT m FROM MUser m ORDER BY m.userId")
public class MUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private String userId;

	private String address;

	private BigDecimal auth;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column(name="CREATE_DATE")
	private Timestamp createDate;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="INVALID_FLG")
	private String invalidFlg;

	@Column(name="MAIL_ADDRESS")
	private String mailAddress;

	private String name;

	private String password;

	private String qualify;

	private String sex;

	@Column(name="UPDATE_DATE")
	private Timestamp updateDate;

	@Column(name="UPDATE_USER")
	private String updateUser;

	//bi-directional many-to-one association to MSection
	@ManyToOne
	@JoinColumn(name="SECTION_ID")
	private MSection MSection;

	//bi-directional many-to-one association to TTime
	@OneToMany(mappedBy="MUser")
	private List<TTime> TTimes;

	public MUser() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getAuth() {
		return this.auth;
	}

	public void setAuth(BigDecimal auth) {
		this.auth = auth;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public String getMailAddress() {
		return this.mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQualify() {
		return this.qualify;
	}

	public void setQualify(String qualify) {
		this.qualify = qualify;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public MSection getMSection() {
		return this.MSection;
	}

	public void setMSection(MSection MSection) {
		this.MSection = MSection;
	}

	public List<TTime> getTTimes() {
		return this.TTimes;
	}

	public void setTTimes(List<TTime> TTimes) {
		this.TTimes = TTimes;
	}

	public TTime addTTime(TTime TTime) {
		getTTimes().add(TTime);
		TTime.setMUser(this);

		return TTime;
	}

	public TTime removeTTime(TTime TTime) {
		getTTimes().remove(TTime);
		TTime.setMUser(null);

		return TTime;
	}


}