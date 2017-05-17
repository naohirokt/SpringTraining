package com.springtraining.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the M_SECTION database table.
 * 
 */
@Entity
@Table(name="M_SECTION")
@NamedQuery(name="MSection.findAll", query="SELECT m FROM MSection m")
public class MSection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SECTION_ID")
	private String sectionId;

	@Column(name="CREATE_DATE")
	private Timestamp createDate;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="INVALID_FLG")
	private String invalidFlg;

	@Column(name="SECTION_NAME")
	private String sectionName;

	@Column(name="UPDATE_DATE")
	private Timestamp updateDate;

	@Column(name="UPDATE_USER")
	private String updateUser;

	//bi-directional many-to-one association to MUser
	@OneToMany(mappedBy="MSection")
	private List<MUser> MUsers;

	public MSection() {
	}

	public String getSectionId() {
		return this.sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
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

	public String getSectionName() {
		return this.sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
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

	public List<MUser> getMUsers() {
		return this.MUsers;
	}

	public void setMUsers(List<MUser> MUsers) {
		this.MUsers = MUsers;
	}

	public MUser addMUser(MUser MUser) {
		getMUsers().add(MUser);
		MUser.setMSection(this);

		return MUser;
	}

	public MUser removeMUser(MUser MUser) {
		getMUsers().remove(MUser);
		MUser.setMSection(null);

		return MUser;
	}

}