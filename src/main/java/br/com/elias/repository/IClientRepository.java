package br.com.elias.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.elias.model.Client;

public interface IClientRepository extends MongoRepository<Client, String> {

	public List<Client> findByName(String name);
	
}
