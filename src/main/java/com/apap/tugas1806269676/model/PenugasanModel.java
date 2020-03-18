package com.apap.tugas1806269676.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.apap.tugas1806269676.model.PustakawanModel;

@Entity
@Table(name = "tugasdi")
public class PenugasanModel implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name = "pustakawan_id")
	private PustakawanModel pustakawan;

	public PustakawanModel getPustakawan() {
		return this.pustakawan;
	}

	public void setPustakawan(PustakawanModel pustakawan) {
		this.pustakawan = pustakawan;
	}

	@Id
	@ManyToOne
	@JoinColumn(name = "perpustakaan_id")
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
