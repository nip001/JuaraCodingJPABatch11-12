package com.juaracoding.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.juaracoding.model.ProductModel;

public interface ProductRepository extends 
JpaRepository<ProductModel, Long>{
	
	List<ProductModel> findByJenis(String jenis);

	//Select * from Product where jenis = "tas" AND merk = "gucci"
	List<ProductModel> findByJenisAndMerk(
			String jenis, 
			String merk);
	
	//Select * from Product where jenis = "tas" AND merk = "gucci" 
	// AND harga = 80000
	List<ProductModel> findByJenisAndMerkAndHarga(
			String jenis, 
			String merk,
			int harga);
	
	//Select * from Product
	//Where jenis = "tas" OR merk = "Gucci"
	List<ProductModel> findByJenisOrMerk(
			String jenis,
			String merk);
	
	//Select * from Product
	//Where jenis = "tas" AND NOT merk = "gucci"
	List<ProductModel> findByJenisAndMerkNot(
			String jenis,
			String merk);
	
	//Select * from product
	//Where not harga = 50000
	List<ProductModel> findByHargaNot(int harga);
	
	
	//Select * from product
	// where harga <= 5000       //LessThanEqual
	//where harga < 5000      //LessThan
	// where harga >= 5000    //GreaterThanEqual
	// where harga > 5000     //GreaterThan
	List<ProductModel> findByHargaGreaterThanEqual(
			int harga);
	
	//Select * from product
	//Where harga between 50000 AND 100000
	List<ProductModel> findByHargaBetween(
			int harga1,int harga2);
}
