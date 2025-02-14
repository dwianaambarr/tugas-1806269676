package com.apap.tugas1806269676.controller;

import java.util.List;
import java.util.Set;

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
import com.apap.tugas1806269676.service.PerpustakaanService;
import com.apap.tugas1806269676.service.PustakawanService;

/**
 * PenugasanController
 * 
 * @author Dwi Ana Ambar Rofiqoh
 *
 */

@Controller
public class PenugasanController {
	@Autowired
	private PustakawanService pustakawanService;
	
	@Autowired
	private PerpustakaanService perpustakaanService;
	
	@RequestMapping(value = "/jadwal/tambah/{nip}", method = RequestMethod.GET)
	private String addJadwal(@PathVariable(value = "nip") String nip, 
			@ModelAttribute PenugasanModel penugasan, Model model) {
		PenugasanModel p = new PenugasanModel();
		List <PerpustakaanModel> perpustakaanList = perpustakaanService.getAllPerpustakaan();
		PustakawanModel pustakawan = pustakawanService.getPustakawanByNip(nip);
		Set<PenugasanModel> jadwal = pustakawan.getPenugasanPustakawan();
		String navigation = "Tambah Jadwal";
		p.setPustakawan(pustakawan);
		model.addAttribute("penugasan", p);
		model.addAttribute("perpustakaanList", perpustakaanList);
		model.addAttribute("penempatan", penugasan.getPerpustakaan());
		model.addAttribute("hari", penugasan.getHari());
		model.addAttribute("pustakawan", pustakawan);
		model.addAttribute("pustakawan_id", pustakawan.getId());
		model.addAttribute("jadwal", jadwal);
		model.addAttribute("navigation", navigation);
		return "add-jadwal";
	}
	
	@RequestMapping(value = "/jadwal/tambah/{nip}", method = RequestMethod.POST, params={"submit"})
	private String addJadwal(@PathVariable(value = "nip") String nip,
			@ModelAttribute PenugasanModel penugasan, 
			@RequestParam(value = "perpustakaan", required = true) PerpustakaanModel perpustakaan, 
			@RequestParam(value = "pustakawan", required = true) PustakawanModel pustakawan, 
			@RequestParam(value = "hari") String hari, Model model) {
		penugasan.setPustakawan(pustakawanService.getPustakawanById(pustakawan.getId()));
		penugasan.setPerpustakaan(perpustakaanService.getPerpustakaanById(perpustakaan.getId()).get());
		penugasan.setHari(hari);
		String navigation = "Berhasil";
		pustakawan.getPenugasanPustakawan().add(penugasan);
		pustakawanService.addPenugasan(pustakawan.getId(), pustakawan);
		model.addAttribute("pustakawan", pustakawan);
		model.addAttribute("navigation", navigation);
		return "add-success";
	}
	
	@RequestMapping(value = "/jadwal/delete/{id}", method = RequestMethod.GET)
	private String deletejadwal(@PathVariable(value = "id") long id, Model model) {
			PustakawanModel pustakawan = pustakawanService.getPustakawanById(id);
//			Set<PenugasanModel> jadwal = pustakawan.getPenugasanPustakawan();
			model.addAttribute("pustakawan", pustakawan);
//			model.addAttribute("jadwal", jadwal);
			String navigation = "Hapus Jadwal";
			model.addAttribute("navigation", navigation);
			return "delete-jadwal";
		}
	
	@RequestMapping(value = "/jadwal/delete/{id}", method = RequestMethod.POST)
	private String delete(@PathVariable(value = "id") long id, Model model) {
			pustakawanService.deletePenugasan(id);
			String navigation = "Berhasil";
			model.addAttribute("navigation", navigation);
			return "delete-success";
	}

}