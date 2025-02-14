package com.apap.tugas1806269676.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1806269676.model.PerpustakaanModel;
import com.apap.tugas1806269676.repository.PerpustakaanDb;


@Service
@Transactional
public class PerpustakaanImpl implements PerpustakaanService {
	@Autowired
	private PerpustakaanDb perpustakaandb;
	
	@Override
	public Optional<PerpustakaanModel> getPerpustakaanById(long id) {
		return perpustakaandb.findById(id);
	}
	
	@Override
	public PerpustakaanModel getPerpustakaanByNama(String nama) {
		return perpustakaandb.findByNama(nama);
	}
	
	@Override
	public void addPerpustakaan(PerpustakaanModel perpustakaan) {
		perpustakaandb.save(perpustakaan);
	}
	
	@Override
	public List<PerpustakaanModel> getAllPerpustakaan() {
		return perpustakaandb.findAll();
	}
	
	@Override
	public void deletePerpustakaan(long id) {
		perpustakaandb.deleteById(id);
	}

}
