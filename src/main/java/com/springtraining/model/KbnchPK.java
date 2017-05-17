package com.springtraining.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the T_TIME database table.
 *
 */
@Embeddable
public class KbnchPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String kbnch;

	@Column(name="KBNCH_CD")
	private String kbnchCd;

	public KbnchPK() {
	}

	public String getKbnch() {
		return this.kbnch;
	}

	public void setKbnch(String kbnch) {
		this.kbnch = kbnch;
	}

	public String getKbnchCd() {
		return this.kbnchCd;
	}

	public void setKbnchCd(String kbnchCd) {
		this.kbnchCd = kbnchCd;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof KbnchPK)) {
			return false;
		}
		KbnchPK castOther = (KbnchPK)other;
		return
			this.kbnch.equals(castOther.kbnch)
			&& this.kbnchCd.equals(castOther.kbnchCd);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.kbnch.hashCode();
		hash = hash * prime + this.kbnchCd.hashCode();

		return hash;
	}
}