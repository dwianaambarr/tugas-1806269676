package com.apap.tugas1806269676.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tugas1806269676.model.PerpustakaanModel;

/**
 * PerpustakaanDb
 * 
 * @author Dwi Ana Ambar Rofiqoh
 *
 */

public interface PerpustakaanDb extends JpaRepository<PerpustakaanModel, Long>{
	PerpustakaanModel findById(long id);
}
