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
		String navigation = "SIP";
		model.addAttribute("navigation", navigation);
		model.addAttribute("pustakawan", pustakawan);
		return "beranda";
	}
	
	@RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.GET)
	private String add(Model model) {
		List <SpesialisasiModel> spesialisasiList = spesialisasiService.getAllSpesialisasi();
		String navigation = "Tambah Pustakawan";
		model.addAttribute("navigation", navigation);
		model.addAttribute("spesialisasi", spesialisasiList);
		model.addAttribute("pustakawanList", new PustakawanModel());
		return "tambahpustakawan";	
	}
	
	@RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.POST, params={"submit"})
	private String addPustakawanSubmit(@RequestParam("spesialisasi_id") long spesialisasi_id, 
			@ModelAttribute PustakawanModel pustakawan, Model model) {
		String navigation = "Berhasil";
		pustakawanService.addPustakawan(pustakawan);
		if (spesialisasi_id != 0) { 
			PustakawanModel pustakawan_id = pustakawanService.getPustakawanById(pustakawan.getId());
					SpesialisasiModel spesialisasiId = spesialisasiService.getSpesialisasiById(spesialisasi_id);
					spesialisasiId.getPustakawanList().add(pustakawan_id);
					spesialisasiService.addSpesialisasi(spesialisasiId);
		}
		model.addAttribute("navigation", navigation);
		return "add";
	}
	
	@RequestMapping(value = "/pustakawan", method = RequestMethod.GET)
	private String detail(@RequestParam(value = "nip") String nip, Model model) {
		PustakawanModel pustakawan = pustakawanService.getPustakawanByNip(nip);
		String navigation = "Detail Pustakawan";
		model.addAttribute("navigation", navigation);
		model.addAttribute("pustakawan", pustakawan);
		return "detailpustakawan";
	}
	
	
	@RequestMapping(value = "/pustakawan/update/{id}", method = RequestMethod.GET)
	private String updatePustakawan(@PathVariable(value = "id") long id, Model model) {
		PustakawanModel old = pustakawanService.getPustakawanById(id);
		List <SpesialisasiModel> spesialisasiList = spesialisasiService.getAllSpesialisasi();
		String navigation = "Ubah Pustakawan";
		model.addAttribute("navigation", navigation);
		model.addAttribute("old", old);
		model.addAttribute("spesialisasi", spesialisasiList);
		model.addAttribute("new", new PustakawanModel());
		return "updatepustakawan";
	}
	
	@RequestMapping(value = "/pustakawan/update/{id}", method = RequestMethod.POST)
	private String updatePustakawan(@ModelAttribute PustakawanModel newPustakawan, 
			@PathVariable(value = "id") long id, Model model) {
		pustakawanService.updatePustakawan(id, newPustakawan);
		PustakawanModel pustakawan = pustakawanService.getPustakawanById(id);
		String navigation = "Berhasil";
		model.addAttribute("navigation", navigation);
		model.addAttribute("pustakawan", pustakawan);
		return "update";
	}
	
	@RequestMapping(value = "/pustakawan/delete/{id}", method = RequestMethod.GET)
	private String deletePilot(@PathVariable(value = "id") long id, Model model) {
			PustakawanModel pustakawan = pustakawanService.getPustakawanById(id);
			model.addAttribute("pustakawan", pustakawan);
			String navigation = "Hapus Pustakawan";
			model.addAttribute("navigation", navigation);
			return "deletepustakawan";
		}
	
	@RequestMapping(value = "/pustakawan/delete/{id}", method = RequestMethod.POST)
	private String deletePilot1(@PathVariable(value = "id") long id, Model model) {
			pustakawanService.deletePustakawan(id);
			String navigation = "Berhasil";
			model.addAttribute("navigation", navigation);
			return "delete";
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
			return "caripustakawan";
		}
	
}
	
