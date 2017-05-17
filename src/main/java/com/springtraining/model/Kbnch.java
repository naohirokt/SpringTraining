package com.springtraining.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the KBNCH database table.
 *
 */
@Entity
@NamedQuery(name="Kbnch.findAll", query="SELECT k FROM Kbnch k")
public class Kbnch implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private KbnchPK id;

	@Column(name="KBNCH_MESHO")
	private String kbnchMesho;

	@Column(name="SORT_NO")
	private BigDecimal sortNo;

	public Kbnch() {
	}

	public KbnchPK getId() {
		return this.id;
	}

	public void setKbnch(KbnchPK id) {
		this.id = id;
	}

	public String getKbnchMesho() {
		return this.kbnchMesho;
	}

	public void setKbnchMesho(String kbnchMesho) {
		this.kbnchMesho = kbnchMesho;
	}

	public BigDecimal getSortNo() {
		return this.sortNo;
	}

	public void setSortNo(BigDecimal sortNo) {
		this.sortNo = sortNo;
	}

}