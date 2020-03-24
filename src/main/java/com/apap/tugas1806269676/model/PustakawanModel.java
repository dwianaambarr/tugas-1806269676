package com.apap.tugas1806269676.model;


import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
		private Set<PenugasanModel> penugasanPustakawan = new HashSet<>();
	
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(name = "punya", 
			joinColumns = @JoinColumn(name = "pustakawan_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "spesialisasi_id", referencedColumnName = "id"))
		private Set<SpesialisasiModel> pustakawanSpesialisasi = new HashSet<>();
		
		public Set<PenugasanModel> getPenugasanPustakawan() {
			return penugasanPustakawan;
		}

		public void setPenugasanPustakawan(Set<PenugasanModel> penugasanPustakawan) {
			this.penugasanPustakawan = penugasanPustakawan;
		}

		public Set<SpesialisasiModel> getPustakawanSpesialisasi() {
			return pustakawanSpesialisasi;
		}

		public void setPustakawanSpesialisasi(Set<SpesialisasiModel> pustakawanSpesialisasi) {
			this.pustakawanSpesialisasi = pustakawanSpesialisasi;
		}

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
		
		public String CreateNIP() {
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
		     
		    PustakawanModel pustakawan = (PustakawanModel) o;
		    return (this.getId() == pustakawan.getId());
		}
		
		@Override
		public int hashCode()
		{
		    final int PRIME = 31;
		    int result = 1;
		    result = PRIME * result + (int) getId();
		    return result;
		}
		
//		public int count1 () {
//			int count = 0;
//			for (int i=0; i<getPenugasanPustakawan().size(); i++) {
//				if(getPenugasanPustakawan().getClass().
//			}
//			count +=1;
//			return 
//		}

}
