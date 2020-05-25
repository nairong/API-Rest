package com.cities.restAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cities.restAPI.model.City;


public interface CityRepository extends JpaRepository<City, Long>{
	City findById(long id);

}
