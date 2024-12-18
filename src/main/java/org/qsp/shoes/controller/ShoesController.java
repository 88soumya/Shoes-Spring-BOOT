package org.qsp.shoes.controller;

import java.util.List;

import org.qsp.shoes.dto.Shoes;
import org.qsp.shoes.service.ShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoesController {
	@Autowired
  ShoesService service;
	
	@PostMapping("/shoes")
	public ResponseEntity<Object> saveShoe(@RequestBody Shoes shoe){
		return service.saveShoe(shoe);
	}
	@PostMapping("/shoes/many")
	public ResponseEntity<Object> saveAllshoes(@RequestBody List<Shoes> shoe){
		return service.saveAllShoe(shoe);
	}
	@GetMapping("/shoes")
	public ResponseEntity<Object> fectcAllShoe(){
		return service.fetchAllShoe();
	}
	@GetMapping("/shoes/{id}")
	public ResponseEntity<Object> fetchById(@PathVariable int id){
		return service.findById(id);
	}
	@GetMapping("/shoes/name/{name}")
	public ResponseEntity<Object> fetchByName(@PathVariable String name){
		return service.fetchByName(name);
	}
	@GetMapping("/shoes/price/greater/{price}")
	public ResponseEntity<Object> fetchByPriceGreater(@PathVariable double price){
		return service.fetchByPriceGreater(price);
	}
	
	//Fetch Products By Stock Between
	@GetMapping("/shoes/quantity/{min}/{max}")
	public ResponseEntity<Object> fetchByStockBetween(@PathVariable int min,@PathVariable int max){
		return service.fetchByStockBetween(min,max);
	}
	@GetMapping("/shoes/values/name/contains/{infi}")
	public ResponseEntity<Object> findByNameContaining( @PathVariable String infi){
		return service.findByNameContaining(infi);
	}
	
	@DeleteMapping("/shoes/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id){
		return service.deleteById(id);
	}
	@PutMapping("/shoes")
	public ResponseEntity<Object> updateRecord(@RequestBody Shoes product){
		return service.updateProduct(product);
	}
	
	//Update Product- PATCH
	@PatchMapping("/shoes/{id}")
	public ResponseEntity<Object> updateRecord(@PathVariable int id,@RequestBody Shoes shoe){
		return service.updateProduct(id,shoe);
	}
}

