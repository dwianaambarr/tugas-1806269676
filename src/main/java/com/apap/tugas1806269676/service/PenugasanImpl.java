package com.apap.tugas1806269676.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1806269676.model.PenugasanModel;
import com.apap.tugas1806269676.model.PerpustakaanModel;
import com.apap.tugas1806269676.repository.PenugasanDb;

@Service
@Transactional
public class PenugasanImpl implements PenugasanService{	
//	@Autowired
//	private PenugasanDb penugasandb;
//
//	@Override
//	public void addPenugasan(PenugasanModel penugasan) {
//	}
//	
//	@Override
//	public List<PenugasanModel> getAllPenugasan() {
//		return penugasandb.findAll();
//	}
//	
//	@Override
//	public PenugasanModel getPenugasanById(long id) {
//		return penugasandb.findById(id);
//	}
//	
//	@Override
//	public void deletePenugasan(long id) {
//		penugasandb.deleteById(id);
//	}
}
