package com.apap.tugas1806269676.service;

import java.util.List;

import com.apap.tugas1806269676.model.PenugasanModel;

public interface PenugasanService {
	void addPenugasan(PenugasanModel penugasan);
	List<PenugasanModel> getAllPenugasan();
	PenugasanModel getPenugasanById(long id);
	void deletePenugasan(long id);
}
