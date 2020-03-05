package br.com.elias.service;

import java.util.List;

import javax.validation.Valid;

import br.com.elias.model.Client;

public interface IClientService {

	public Client insert(Client client);

	public Client findById(String id);

	public List<Client> findByName(String name);

	public void delete(String id);

	public Client update(String id, Client client);

}
