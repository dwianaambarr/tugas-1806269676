package com.apap.tugas1806269676.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1806269676.model.PustakawanModel;
import com.apap.tugas1806269676.repository.PustakawanDb;


@Service
@Transactional
public class PustakawanImpl implements PustakawanService {
	@Autowired
	private PustakawanDb pustakawandb;
	
	@Override
	public void addPustakawan(PustakawanModel pustakawan) {
		this.createNip(pustakawan);
		pustakawandb.save(pustakawan);
	}

	
	@Override
	public List<PustakawanModel> getAllPustakawan() {
		return pustakawandb.findAll();
	}
	
	@Override
	public void createNip(PustakawanModel pustakawan) {
		pustakawan.setNip(pustakawan.CreateNIP());
	}
	
	
	@Override
	public PustakawanModel getPustakawanById(long id) {
		return pustakawandb.findById(id);
	}
	
	@Override
	public PustakawanModel getPustakawanByNip(String nip) {
		return pustakawandb.findByNip(nip);
	}
	
	@Override
	public void updatePustakawan(long id, PustakawanModel pustakawan) {
		PustakawanModel old = this.getPustakawanById(id);
		old.setNama(pustakawan.getNama());
		old.setNip(pustakawan.CreateNIP());
		old.setJenis_kelamin(pustakawan.getJenis_kelamin());
		old.setTanggal_lahir(pustakawan.getTanggal_lahir());
		old.setTempat_lahir(pustakawan.getTempat_lahir());
		old.setPustakawanSpesialisasi(pustakawan.getPustakawanSpesialisasi());
		pustakawandb.save(old);
	}
	
	@Override
	public void deletePustakawan(long id) {
		pustakawandb.deleteById(id);
	}
	
	@Override
	public void addPenugasan(long id, PustakawanModel p) {
		PustakawanModel pustakawan = this.getPustakawanById(id);
		pustakawan.setPenugasanPustakawan(p.getPenugasanPustakawan());
	}
	
	@Override
	public void deletePenugasan(long id) {
		PustakawanModel pustakawan = this.getPustakawanById(id);
		pustakawan.getPenugasanPustakawan().removeAll(pustakawan.getPenugasanPustakawan());
	}
	
	@Override
	public int count(){
		List<PustakawanModel> pustakawan = this.getAllPustakawan();
		int count=0;
		for(int i=0; i<pustakawan.size(); i++){
			for(int j=0; j<pustakawan.get(i).iterasi().size();j++) {
				if(pustakawan.get(i).iterasi().get(j).getId()==3) {
					count+=1;
			}
		} 
		} return count;
	}

}
