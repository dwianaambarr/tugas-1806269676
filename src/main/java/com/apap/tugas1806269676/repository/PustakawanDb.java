package com.apap.tugas1806269676.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tugas1806269676.model.PustakawanModel;

/**
 * PustakawanDb
 * 
 * @author Dwi Ana Ambar Rofiqoh
 *
 */

public interface PustakawanDb extends JpaRepository<PustakawanModel, Long>{
	PustakawanModel findById(long id);
	PustakawanModel findByNip(String nip);
	void deleteById(long id);
}
