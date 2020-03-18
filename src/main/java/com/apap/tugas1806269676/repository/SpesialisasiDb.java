package com.apap.tugas1806269676.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tugas1806269676.model.SpesialisasiModel;

/**
 * SpesialisasiDb
 * 
 * @author Dwi Ana Ambar Rofiqoh
 *
 */

public interface SpesialisasiDb extends JpaRepository<SpesialisasiModel, Long>{
	SpesialisasiModel findById(long id);
}
