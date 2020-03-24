package com.apap.tugas1806269676.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.apap.tugas1806269676.model.PustakawanModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tugasdi")
public class PenugasanModel implements Serializable {	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "pustakawan_id")
	private PustakawanModel pustakawan;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "perpustakaan_id")
	private PerpustakaanModel perpustakaan;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "hari", nullable = false)
	private String hari;

	public PustakawanModel getPustakawan() {
		return pustakawan;
	}

	public void setPustakawan(PustakawanModel pustakawan) {
		this.pustakawan = pustakawan;
	}

	public PerpustakaanModel getPerpustakaan() {
		return perpustakaan;
	}

	public void setPerpustakaan(PerpustakaanModel perpustakaan) {
		this.perpustakaan = perpustakaan;
	}

	public String getHari() {
		return hari;
	}

	public void setHari(String hari) {
		this.hari = hari;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((perpustakaan == null) ? 0 : perpustakaan.hashCode());
		result = prime * result + ((pustakawan == null) ? 0 : pustakawan.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
	    if(o == null)
	    {
	        return false;
	    }
	    if (o == this)
	    {
	        return true;
	    }
	    if (getClass() != o.getClass())
	    {
	        return false;
	    }
		PenugasanModel penugasan = (PenugasanModel) o;
		if (perpustakaan == null) {
			if (penugasan.perpustakaan != null) {
				return false;
			}
		} else if (!perpustakaan.equals(penugasan.perpustakaan)) {
			return false;
		}
		if (pustakawan == null) {
			if (penugasan.pustakawan != null) {
				return false;
			}
		} else if (!pustakawan.equals(penugasan.pustakawan)) {
			return false;
		}
		return true;
	}
	
	
}
