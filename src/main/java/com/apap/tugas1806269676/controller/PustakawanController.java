package com.apap.tugas1806269676.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1806269676.model.PerpustakaanModel;
import com.apap.tugas1806269676.model.PustakawanModel;
import com.apap.tugas1806269676.model.SpesialisasiModel;
import com.apap.tugas1806269676.service.PerpustakaanService;
import com.apap.tugas1806269676.service.PustakawanService;
import com.apap.tugas1806269676.service.SpesialisasiService;


/**
 * PustakawanController
 * 
 * @author Dwi Ana Ambar Rofiqoh
 *
 */

@Controller
public class PustakawanController {
	@Autowired
	private PustakawanService pustakawanService;
	
	@Autowired
	private SpesialisasiService spesialisasiService;
	
	@Autowired
	private PerpustakaanService perpustakaanService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	private String viewPustakawan(Model model) {
		List<PustakawanModel> pustakawan = pustakawanService.getAllPustakawan();
		List<SpesialisasiModel> spesialisasi = spesialisasiService.getAllSpesialisasi();
		String navigation = "SIP";
		model.addAttribute("navigation", navigation);
		model.addAttribute("pustakawan", pustakawan);
		model.addAttribute("spesialisasi", spesialisasi);
		return "beranda";
	}
	
	@RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.GET)
	private String add(Model model) {
		List <SpesialisasiModel> spesialisasiList = spesialisasiService.getAllSpesialisasi();
		String navigation = "Tambah Pustakawan";
		model.addAttribute("navigation", navigation);
		model.addAttribute("spesialisasi", spesialisasiList);
		model.addAttribute("pustakawan", new PustakawanModel());
		return "add-pustakawan";	
	}
	
	@RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.POST, params={"submit"})
	private String addPustakawanSubmit(@RequestParam (value= "spesialisasi", required = false) SpesialisasiModel spesialisasi, 
			@ModelAttribute PustakawanModel pustakawan, Model model) {
		String navigation = "Berhasil";
		pustakawanService.addPustakawan(pustakawan);
		if (spesialisasi != null) { 
			Optional<SpesialisasiModel> spesialisasiId = spesialisasiService.getSpesialisasiById(spesialisasi.getId());
			pustakawan.getPustakawanSpesialisasi().add(spesialisasiId.get());
		}
		model.addAttribute("navigation", navigation);
		return "add-success";
	} 
		
	@RequestMapping(value = "/pustakawan", method = RequestMethod.GET)
	private String detail(@RequestParam(value = "nip") String nip, Model model) {
		PustakawanModel pustakawan = pustakawanService.getPustakawanByNip(nip);
		String navigation = "Detail Pustakawan";
		model.addAttribute("navigation", navigation);
		model.addAttribute("pustakawan", pustakawan);
		return "detail-pustakawan";
	}
	
	
	@RequestMapping(value = "/pustakawan/update/{id}", method = RequestMethod.GET)
	private String updatePustakawan(@PathVariable(value = "id") long id, Model model) {
		PustakawanModel old = pustakawanService.getPustakawanById(id);
		List <SpesialisasiModel> spesialisasi = spesialisasiService.getAllSpesialisasi();
		String navigation = "Ubah Pustakawan";
		model.addAttribute("navigation", navigation);
		model.addAttribute("old", old);
		model.addAttribute("spesialisasi", spesialisasi);
		model.addAttribute("new", new PustakawanModel());
		return "update-pustakawan";
	}
	
	@RequestMapping(value = "/pustakawan/update/{id}", method = RequestMethod.POST)
	private String updatePustakawan(@ModelAttribute PustakawanModel newPustakawan, 
			@PathVariable(value = "id") long id, Model model) {
		pustakawanService.updatePustakawan(id, newPustakawan);
		PustakawanModel pustakawan = pustakawanService.getPustakawanById(id);
		String navigation = "Berhasil";
		model.addAttribute("navigation", navigation);
		model.addAttribute("pustakawan", pustakawan);
		return "update-success";
	}
	
	@RequestMapping(value = "/pustakawan/delete/{id}", method = RequestMethod.GET)
	private String deletePustakawan(@PathVariable(value = "id") long id, Model model) {
			PustakawanModel pustakawan = pustakawanService.getPustakawanById(id);
			model.addAttribute("pustakawan", pustakawan);
			String navigation = "Hapus Pustakawan";
			model.addAttribute("navigation", navigation);
			return "delete-pustakawan";
		}
	
	@RequestMapping(value = "/pustakawan/delete/{id}", method = RequestMethod.POST)
	private String delete(@PathVariable(value = "id") long id, Model model) {
			pustakawanService.deletePustakawan(id);
			String navigation = "Berhasil";
			model.addAttribute("navigation", navigation);
			return "delete-success";
	}
	
	@RequestMapping(value = "/cari", method = RequestMethod.GET)
	private String cari(Model model) {
			List <SpesialisasiModel> spesialisasiList = spesialisasiService.getAllSpesialisasi();
			List <PerpustakaanModel> perpustakaanList = perpustakaanService.getAllPerpustakaan();
			List <PustakawanModel> pustakawan = pustakawanService.getAllPustakawan();
			String navigation = "Cari Pustakawan";
			model.addAttribute("spesialisasi", spesialisasiList);
			model.addAttribute("pustakawan", pustakawan);
			model.addAttribute("perpustakaan", perpustakaanList);
			model.addAttribute("navigation", navigation);
			return "search-pustakawan";
		}
	
	@RequestMapping(value = "/statistik", method = RequestMethod.GET)
	private String statistik(Model model) {
			List <SpesialisasiModel> spesialisasiList = spesialisasiService.getAllSpesialisasi();
			List <PustakawanModel> pustakawan = pustakawanService.getAllPustakawan();
//			Optional<SpesialisasiModel> sp1 = spesialisasiService.getSpesialisasiById(1);
//			Optional<SpesialisasiModel> sp2 = spesialisasiService.getSpesialisasiById(2);
//			Optional<SpesialisasiModel> sp3 = spesialisasiService.getSpesialisasiById(3);
//			Optional<SpesialisasiModel> sp4 = spesialisasiService.getSpesialisasiById(4);
//			Optional<SpesialisasiModel> sp5 = spesialisasiService.getSpesialisasiById(5);
//			
//			
			String navigation = "Statistik";
			model.addAttribute("spesialisasi", spesialisasiList);
//			model.addAttribute("sp1", sp1.ge);
//			model.addAttribute("sp2", spesialisasiList);
//			model.addAttribute("sp3", spesialisasiList);
//			model.addAttribute("sp4", spesialisasiList);
//			model.addAttribute("sp5", spesialisasiList);
			model.addAttribute("pustakawan", pustakawan);
			model.addAttribute("navigation", navigation);
			return "statistik";
		}
	
}
	
