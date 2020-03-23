package com.apap.tugas1806269676.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "spesialisasi")
public class SpesialisasiModel implements Serializable{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotNull
		@Size(max=50)
		@Column(name = "nama", nullable = false)
		private String nama;
		
		@NotNull
		@Size(max = 500)
		@Column(name = "deskripsi")
		private String deskripsi;
		
		
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
		     
		    SpesialisasiModel spesialisasi = (SpesialisasiModel) o;
		    return (this.getId() == spesialisasi.getId());
		}
		
		@Override
		public int hashCode()
		{
		    final int PRIME = 31;
		    int result = 1;
		    result = PRIME * result + (int) getId();
		    return result;
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

		public String getDeskripsi() {
			return deskripsi;
		}

		public void setDeskripsi(String deskripsi) {
			this.deskripsi = deskripsi;
		}

}
