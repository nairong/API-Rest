package com.cities.restAPI.resource;

import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cities.restAPI.model.City;
import com.cities.restAPI.repository.CityRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
public class CityResource {

	@Autowired
	CityRepository cityRepository;
	
	@ApiOperation(value="Retorna uma lista de citys")
	@GetMapping("/cidades")
	public List<City> listacitys(){
		return cityRepository.findAll();
	}
	
	@ApiOperation(value="Retorna um city unico")
	@GetMapping("/city/{id}")
	public City listacityUnico(@PathVariable(value="id") long id){
		return cityRepository.findById(id);
	}
	
	@ApiOperation(value="Salva um city")
	@PostMapping("/city")
	public City salvacity(@RequestBody /*@Valid*/ City city) {
		return cityRepository.save(city);
	}
	
	@ApiOperation(value="Deleta um city")
	@DeleteMapping("/city")
	public void deletacity(@RequestBody /*@Valid*/ City city) {
		cityRepository.delete(city);
	}
	
	@ApiOperation(value="Atualiza um city")
	@PutMapping("/city")
	public City atualizacity(@RequestBody /*@Valid*/ City city) {
		return cityRepository.save(city);
	}
	 

}

