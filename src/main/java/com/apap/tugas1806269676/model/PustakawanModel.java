package com.apap.tugas1806269676.model;


import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.apap.tugas1806269676.model.SpesialisasiModel;
import com.apap.tugas1806269676.model.PenugasanModel;

	@Entity
	@Table(name = "pustakawan")
	public class PustakawanModel implements Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotNull
		@Size(max = 50)
		@Column(name = "nama", nullable = false)
		private String nama;
		
		@NotNull
		@Size(min = 13, max = 13)
		@Column(name = "nip", nullable = false, unique = true)
		private String nip;
		
		@NotNull
		@Size(max = 13)
		@Column(name = "tempat_lahir")
		private String tempat_lahir;
		
		@NotNull
		@Column(name = "tanggal_lahir", nullable = false)
		private Date tanggal_lahir;
		
		@NotNull
		@Column(name = "jenis_kelamin", nullable = false)
		private int jenis_kelamin;
		
		@OneToMany(mappedBy = "pustakawan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private List<PenugasanModel> penugasanPustakawan;
	
		@ManyToMany(mappedBy = "pustakawanList", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private List<SpesialisasiModel> pustakawanSpesialisasi;
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNama() {
			return nama;
		}

		public void setNama(String nama) {
			this.nama = nama;
		}

		public String getNip() {
			return nip;
		}
		
		public  String CreateNIP() {
			//Random Alphabet
			Random r = new Random();
	        String random =  String.valueOf((char)(r.nextInt(26)+'A') + String.valueOf((char)(r.nextInt(26)+'A')));	
	        //Formatting Year
			int year = Calendar.getInstance().get(Calendar.YEAR);
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy");
			String strDate= formatter.format(getTanggal_lahir());			
			return String.valueOf(year) + strDate + getJenis_kelamin() + random ;
		}
		
		public void setNip(String nip) {
			this.nip = nip;
		}

		public String getTempat_lahir() {
			return tempat_lahir;
		}

		public void setTempat_lahir(String tempat_lahir) {
			this.tempat_lahir = tempat_lahir;
		}

		public Date getTanggal_lahir() {
			return tanggal_lahir;
		}

		public void setTanggal_lahir(Date tanggal_lahir) {
			this.tanggal_lahir = tanggal_lahir;
		}

		public int getJenis_kelamin() {
			return this.jenis_kelamin;
		}
		
		public void setJenis_kelamin(int jenis_kelamin) {
			this.jenis_kelamin = jenis_kelamin;
		}

		public List<PenugasanModel> getPenugasanPustakawan() {
			return penugasanPustakawan;
		}

		public void setPenugasanPustakawan(List<PenugasanModel> penugasanPustakawan) {
			this.penugasanPustakawan = penugasanPustakawan;
		}

		public List<SpesialisasiModel> getPustakawanSpesialisasi() {
			return pustakawanSpesialisasi;
		}

		public void setPustakawanSpesialisasi(List<SpesialisasiModel> pustakawanSpesialisasi) {
			this.pustakawanSpesialisasi = pustakawanSpesialisasi;
		}

}
