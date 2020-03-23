package com.apap.tugas1806269676.service;

import java.util.List;
import java.util.Optional;

import com.apap.tugas1806269676.model.SpesialisasiModel;

public interface SpesialisasiService {
	List <SpesialisasiModel> getAllSpesialisasi();
	void addSpesialisasi(SpesialisasiModel spesialisasi);
	Optional<SpesialisasiModel> getSpesialisasiById(long id);
}
