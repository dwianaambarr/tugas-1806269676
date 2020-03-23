package com.apap.tugas1806269676.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1806269676.model.PenugasanModel;
import com.apap.tugas1806269676.model.PerpustakaanModel;
import com.apap.tugas1806269676.model.PustakawanModel;
import com.apap.tugas1806269676.model.SpesialisasiModel;
import com.apap.tugas1806269676.service.PenugasanService;
import com.apap.tugas1806269676.service.PerpustakaanService;
import com.apap.tugas1806269676.service.PustakawanService;

@Controller
public class PenugasanController {	
	@Autowired
	private PerpustakaanService perpustakaanService;
	
	@Autowired
	private PustakawanService pustakawanService;
	
	@Autowired
	private PenugasanService penugasanService;

	@RequestMapping(value = "/jadwal/tambah/{nip}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "nip") String nip, Model model) {
//		List <PerpustakaanModel> perpustakaanList = perpustakaanService.getAllPerpustakaan();
//		List <PenugasanModel> penugasan = penugasanService.getAllPenugasan();
//		PustakawanModel pustakawan = pustakawanService.getPustakawanByNip(nip);
//		String navigation = "Tambah Jadwal";
//		model.addAttribute("navigation", navigation);
//		model.addAttribute("perpustakaan", perpustakaanList);
//		model.addAttribute("pustakawan", pustakawan);
//		model.addAttribute("penugasan", penugasan);
//		model.addAttribute("pustakawanList", new PenugasanModel());
		return "jadwaltugas";	
	}
	
//	@RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.POST, params={"submit"})
//	private String addPustakawanSubmit(@RequestParam("spesialisasi_id") long spesialisasi_id, 
//			@ModelAttribute PustakawanModel pustakawan, Model model) {
//		String navigation = "Berhasil";
//		pustakawanService.addPustakawan(pustakawan);
//		if (spesialisasi_id != 0) { 
//			PustakawanModel pustakawan_id = pustakawanService.getPustakawanById(pustakawan.getId());
//					SpesialisasiModel spesialisasiId = spesialisasiService.getSpesialisasiById(spesialisasi_id);
//					spesialisasiId.getPustakawanList().add(pustakawan_id);
//					spesialisasiService.addSpesialisasi(spesialisasiId);
//		}
//		model.addAttribute("navigation", navigation);
//		return "add";
//	}
	
	@RequestMapping(value = "/jadwal/delete/{id}", method = RequestMethod.GET)
	private String deleteJadwal(@PathVariable(value = "id") long id, Model model) {
//			PenugasanModel penugasan = penugasanService.getPenugasanById(id);
//			model.addAttribute("penugasan", penugasan);
//			String navigation = "Hapus Jadwal";
//			model.addAttribute("navigation", navigation);
			return "deletejadwal";
		}
	
	@RequestMapping(value = "/jadwal/delete/{id}", method = RequestMethod.POST)
	private String deleteJadwal1(@PathVariable(value = "id") long id, Model model) {
//			penugasanService.deletePenugasan(id);
//				String navigation = "Berhasil!";
//				model.addAttribute("navigation", navigation);
			return "delete";
		}
	
}
