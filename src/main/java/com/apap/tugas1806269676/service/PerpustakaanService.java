package com.apap.tugas1806269676.service;


import java.util.List;
import java.util.Optional;

import com.apap.tugas1806269676.model.PerpustakaanModel;

public interface PerpustakaanService {
		void addPerpustakaan(PerpustakaanModel perpustakaan);
		List<PerpustakaanModel> getAllPerpustakaan();
		Optional<PerpustakaanModel> getPerpustakaanById(long id);
		PerpustakaanModel getPerpustakaanByNama(String nama);
		void deletePerpustakaan(long id);
}
