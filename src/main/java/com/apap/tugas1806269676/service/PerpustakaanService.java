package com.apap.tugas1806269676.service;


import java.util.List;

import com.apap.tugas1806269676.model.PerpustakaanModel;

public interface PerpustakaanService {
		void addPerpustakaan(PerpustakaanModel perpustakaan);
		List<PerpustakaanModel> getAllPerpustakaan();
		PerpustakaanModel getPerpustakaanById(long id);
}
