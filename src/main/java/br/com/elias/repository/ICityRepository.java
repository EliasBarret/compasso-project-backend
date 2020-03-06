package br.com.elias.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.elias.model.City;

public interface ICityRepository extends MongoRepository<City, String> {

	public List<City> findByName(String name);
	
	public List<City> findByState(String state);
	
}
