package com.apap.tugas1806269676.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "perpustakaan")
public class PerpustakaanModel implements Serializable{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotNull
		@Size(max=50)
		@Column(name = "nama", nullable = false)
		private String nama;
		
		@NotNull
		@Size(max = 500)
		@Column(name = "lokasi")
		private String lokasi;
		
		@OneToMany(mappedBy = "perpustakaan", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
		private Set<PenugasanModel> penugasanList = new HashSet<>();
		
		public Set<PenugasanModel> getPenugasanList() {
			return penugasanList;
		}

		public void setPenugasanList(Set<PenugasanModel> penugasanList) {
			this.penugasanList = penugasanList;
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

		public String getLokasi() {
			return lokasi;
		}

		public void setLokasi(String lokasi) {
			this.lokasi = lokasi;
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
		     
		    PerpustakaanModel perpustakaan = (PerpustakaanModel) o;
		    return (this.getId() == perpustakaan.getId());
		}
		
		@Override
		public int hashCode()
		{
		    final int PRIME = 31;
		    int result = 1;
		    result = PRIME * result + (int) getId();
		    return result;
		}
}
