package com.juaracoding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.model.MobilModel;
import com.juaracoding.repository.MobilRepository;

@RestController
@RequestMapping("/mobil")
public class MobilController {
	@Autowired
	MobilRepository mobilRepo;

	@GetMapping("/")
	private List<MobilModel> getAllMobil() {
		return mobilRepo.findAll();
	}
	
	@GetMapping("/{merk}")
	private List<MobilModel> getMobilByMerk(
			@PathVariable(value="merk") String merk){
		return mobilRepo.findByMerk(merk);
	}
	
	@GetMapping("/tahun/{tahun}")
	private List<MobilModel> getMobilByTahun(
			@PathVariable(value="tahun")int tahun){
		return mobilRepo.findByTahun(tahun);
	}
}
