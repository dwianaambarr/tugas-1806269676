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

/**
 * PerpustakaanController
 * 
 * @author Dwi Ana Ambar Rofiqoh
 *
 */

@Controller
public class PerpustakaanController {
	@Autowired
	private PerpustakaanService perpustakaanService;
	
	@RequestMapping(value = "/perpustakaan", method = RequestMethod.GET)
	private String viewPustakawan(Model model) {
		List<PerpustakaanModel> perpustakaan = perpustakaanService.getAllPerpustakaan();	
		String navigation = "Daftar Perpustakaan";
		model.addAttribute("navigation", navigation);
		model.addAttribute("perpustakaan", perpustakaan);
		return "daftarperpustakaan";
	}
	
	@RequestMapping(value = "/perpustakaan/tambah", method = RequestMethod.GET)
	private String add(Model model) {
		String navigation = "Tambah Perpustakaan";
		model.addAttribute("navigation", navigation);
		model.addAttribute("perpustakaan", new PerpustakaanModel());
		return "tambahperpustakaan";	
	}
	
	@RequestMapping(value = "/perpustakaan/tambah", method = RequestMethod.POST, params={"submit"})
	private String addPustakawanSubmit(@ModelAttribute PerpustakaanModel perpustakaan, Model model) {
		String navigation = "Berhasil";
		perpustakaanService.addPerpustakaan(perpustakaan);
		model.addAttribute("navigation", navigation);
		return "add";
	}
	
	@RequestMapping(value = "/perpustakaan/delete/{id}", method = RequestMethod.GET)
	private String deletePilot(@PathVariable(value = "id") long id, Model model) {
			PerpustakaanModel perpustakaan = perpustakaanService.getPerpustakaanById(id);
			model.addAttribute("perpustakaan", perpustakaan);
			String navigation = "Hapus Perpustakaan";
			model.addAttribute("navigation", navigation);
			return "deleteperpustakaan";
		}
	
	@RequestMapping(value = "/perpustakaan/delete/{id}", method = RequestMethod.POST)
	private String deletePilot1(@PathVariable(value = "id") long id, Model model) {
			perpustakaanService.deletePerpustakaan(id);
			String navigation = "Berhasil";
			model.addAttribute("navigation", navigation);
			return "delete";
		}
}
