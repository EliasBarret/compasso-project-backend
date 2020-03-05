package br.com.elias.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.elias.model.City;

public interface ICityRepository extends MongoRepository<City, String> {

	public Optional<City> findByName(String name);
	
	public Optional<City> findByState(String state);
	
}
