package org.qsp.shoes.repository;

import java.util.List;

import org.qsp.shoes.dto.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ShoesRepository extends JpaRepository<Shoes, Integer>{

	

	List<Shoes> findBysBrand(String name);

	List<Shoes> findByPriceGreaterThanEqual(double price);

	List<Shoes> findByquantityBetween(int min, int max);

	List<Shoes> findBysBrandContaining(String infi);

	

	

}
