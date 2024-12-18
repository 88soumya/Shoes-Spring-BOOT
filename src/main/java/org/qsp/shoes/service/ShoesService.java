package org.qsp.shoes.service;

import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.qsp.shoes.dto.Shoes;
import org.qsp.shoes.repository.ShoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ShoesService {

	@Autowired
	ShoesRepository repository;
	
	public ResponseEntity<Object> saveShoe(Shoes shoe) {
		repository.save(shoe);
			Map<String,Object>map=new HashMap<String, Object>();
			map.put("message", "data is saved sucessfully");
			map.put("data", shoe);
			return new ResponseEntity<Object>(map,HttpStatus.CREATED);
		}

	public ResponseEntity<Object> saveAllShoe(List<Shoes> shoe) {
		// TODO Auto-generated method stub
	  repository.saveAll(shoe);
	  Map<String,Object>map=new HashMap<String, Object>();
	  map.put("message", "data is saved sucessfully");
		map.put("data", shoe);
		return new ResponseEntity<Object>(map,HttpStatus.CREATED);
	}

	public ResponseEntity<Object> fetchAllShoe() {
		List<Shoes>list=repository.findAll();
		if(list.isEmpty()) {
			Map<String,Object>map=new HashMap<String, Object>();
			  map.put("error", "data is not presnt");
			return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
			
		}
		else {
			Map<String,Object>map=new HashMap<String, Object>();
	
			  map.put("message", "all data is fetched");
			  map.put("data", list);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
			
		}
	}

	public ResponseEntity<Object> findById(int id) {
		// TODO Auto-generated method stub
		Optional<Shoes>optional=repository.findById(id);
		if(optional.isEmpty()) {
			Map<String,Object>map=new HashMap<String, Object>();
			  map.put("error", "data is not presnt with id "+id);
			return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
			
		}
		else {
			Map<String,Object>map=new HashMap<String, Object>();
			
			  map.put("message", "all data is fetched");
			  map.put("data", optional);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> fetchByName(String name) {
		List<Shoes> list = repository.findBysBrand(name);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found with Name :"+name);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "shoes Found");
			map.put("data", list);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}
	public ResponseEntity<Object> fetchByPriceGreater(double price) {
		List<Shoes> list = repository.findByPriceGreaterThanEqual(price);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No shoe Found Price Greater Than: "+price);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Products Found");
			map.put("data", list);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}
	public ResponseEntity<Object> fetchByStockBetween(int min, int max) {
		List<Shoes> list = repository.findByquantityBetween(min,max);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No shoe Found Stock Between: "+min+" and "+max);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "shoe Found");
			map.put("data", list);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}
	
	public ResponseEntity<Object> findByNameContaining(String infi) {
		// TODO Auto-generated method stub
		List<Shoes> list = repository.findBysBrandContaining(infi);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found ");
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Products Found");
			map.put("data", list);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}
	public ResponseEntity<Object> deleteById(int id) {
		Optional<Shoes> optional = repository.findById(id);
		if(optional.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Product Found with Id: "+id);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			repository.deleteById(id);
			map.put("message", "Product Deleted Success");
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}
	public ResponseEntity<Object> updateProduct(Shoes shoes) {
		repository.save(shoes);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Product Updated Success");
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
	public ResponseEntity<Object> updateProduct(int id, Shoes shoe) {
		Optional<Shoes> optional = repository.findById(id);
		if(optional.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Product Found with Id: "+id);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			
			Shoes existingProduct = optional.get();
		  if(shoe.getPrice()!=0) {
			  existingProduct.setPrice(shoe.getPrice());
		  }
		  if(shoe.getQuantity()!=0) {
			  existingProduct.setQuantity(shoe.getQuantity());
		  }
		  if(shoe.getSBrand()!=null) {
			  existingProduct.setSBrand(shoe.getSBrand());
		  }
		  if(shoe.getSColor()!=null) {
			  existingProduct.setSColor(shoe.getSColor());
		  }
			  
		  
			
			repository.save(existingProduct);
			map.put("message", "Product Updated Success");
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
}
}
