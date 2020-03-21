package com.apap.tugas1806269676.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pustakawan_id", referencedColumnName = "id", nullable = false)
	private PustakawanModel pustakawan;

	public PustakawanModel getPustakawan() {
		return this.pustakawan;
	}

	public void setPustakawan(PustakawanModel pustakawan) {
		this.pustakawan = pustakawan;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "perpustakaan_id", referencedColumnName = "id", nullable = false)
	private PerpustakaanModel perpustakaan;

	public PerpustakaanModel getPerpustakaan() {
		return this.perpustakaan;
	}

	public void setPerpustakaan(PerpustakaanModel perpustakaan) {
		this.perpustakaan = perpustakaan;
	}

	@NotNull
	@Size(max = 50)
	@Column(name = "hari", nullable = false)
	private String hari;

	public String getHari() {
		return this.hari;
	}

	public void setHari(String hari) {
		this.hari = hari;
	}
	
}
