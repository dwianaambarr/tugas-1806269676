package com.apap.tugas1806269676.service;


import java.util.List;

import com.apap.tugas1806269676.model.PustakawanModel;

public interface PustakawanService {
		void addPustakawan(PustakawanModel pustakawan);
		List<PustakawanModel> getAllPustakawan();
		void createNip(PustakawanModel pustakawan);
		PustakawanModel getPustakawanById(long id);
		PustakawanModel getPustakawanByNip(String nip);
		void updatePustakawan(long id, PustakawanModel pustakawan);
		void deletePustakawan(long id);
		void addPenugasan(long id, PustakawanModel pustakawan);
		void deletePenugasan(long id);
		int count();
}
