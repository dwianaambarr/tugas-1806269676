package com.apap.tugas1806269676.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tugas1806269676.model.PerpustakaanModel;
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
}
