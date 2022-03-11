package com.juaracoding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.model.ProductModel;
import com.juaracoding.repository.MobilRepository;
import com.juaracoding.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	
	@GetMapping("/{id}")
	private ProductModel getByIdProduct(
			@PathVariable("id") long id) {
		return productRepository.findById(id).get();
	}
	
	@GetMapping("/")
	private List<ProductModel> getAllProduct() {
		return productRepository.findAll();
	}
	
	@GetMapping("/cari")
	private List<ProductModel> getByJenisProduct(
			@RequestParam(name="jenis")String jenis){
		return productRepository.findByJenis(jenis);
	}
	
	@PostMapping("/saveAll")
	private String saveAllProduct(
			@RequestBody List<ProductModel> datayangdisimpan) {
		productRepository.saveAll(datayangdisimpan);
		return "data berhasil disimpan";
	}
	
	@PostMapping("/")
	private List<ProductModel> saveProduct(
			@RequestBody ProductModel product) {

		productRepository.save(product);
		return productRepository.findAll();
	}
	
	@DeleteMapping("/")
	private List<ProductModel> deleteByIdProduct(
			@RequestParam(name="id") long id) {
		productRepository.deleteById(id);
		return productRepository.findAll();
	}
	
	@PatchMapping("/")
	private String updateProduct(
			@RequestParam(name="id")long id,
			@RequestBody ProductModel product) {
		ProductModel data= productRepository.findById(id).get();
		if(product.getJenis() == null) {
			product.setJenis(data.getJenis());
		} else if(product.getMerk() == null) {
			product.setMerk(data.getMerk());
		}else if (product.getHarga() == 0) {
			product.setHarga(data.getHarga());
		}
		productRepository.save(product);
		return "selamat anda berhasil memperbarui";
	}
	
	@GetMapping("/carimerkdanjenis/")
	private List<ProductModel> getProductByJenisDanMerk(
			@RequestParam(name="jenis") String jenis,
			@RequestParam(name="merk") String merk) {
		
		return productRepository.findByJenisAndMerk(jenis, merk);
	}
	
	@GetMapping("/carimerkataujenis/")
	private List<ProductModel> getProductByJenisAtauMerk(
			@RequestParam(name="jenis") String jenis,
			@RequestParam(name="merk") String merk) {
		
		return productRepository.findByJenisOrMerk(jenis, merk);
	}
	
	@GetMapping("/greaterthan/{harga}")
	private List<ProductModel> getProductByHargaTerbesar(
			@PathVariable("harga") int harga) {
		return productRepository.findByHargaGreaterThanEqual(harga);
	}
	
	@GetMapping("/betweenharga")
	private List<ProductModel> getProductBetweenHarga(
			@RequestParam(name="harga1")int harga1,
			@RequestParam(name="harga2") int harga2){
		return productRepository.findByHargaBetween(harga1, harga2);
	}
	
	
}
