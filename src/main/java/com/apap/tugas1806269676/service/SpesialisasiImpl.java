package com.apap.tugas1806269676.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1806269676.model.SpesialisasiModel;
import com.apap.tugas1806269676.repository.SpesialisasiDb;



@Service
@Transactional
public class SpesialisasiImpl implements SpesialisasiService {
	@Autowired
	private SpesialisasiDb spesialisasidb;
	
	@Autowired
	private PustakawanService pustakawanService;
	
	
	@Override
	public List<SpesialisasiModel> getAllSpesialisasi() {
		return spesialisasidb.findAll();
	}
	
	@Override
	public void addSpesialisasi(SpesialisasiModel spesialisasi) {
		spesialisasidb.save(spesialisasi);
	}
	
	@Override
	public Optional<SpesialisasiModel> getSpesialisasiById(long id) {
		return spesialisasidb.findById(id);
	}
	
}

