package com.juaracoding.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juaracoding.model.MobilModel;

public interface MobilRepository extends JpaRepository<MobilModel, Long>{
	List<MobilModel> findByMerk(String merk);
	List<MobilModel> findByTahun(int tahun);
}
