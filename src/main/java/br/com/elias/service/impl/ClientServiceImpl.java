package br.com.elias.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elias.exception.RestException;
import br.com.elias.model.City;
import br.com.elias.model.Client;
import br.com.elias.repository.ICityRepository;
import br.com.elias.repository.IClientRepository;
import br.com.elias.service.IClientService;

@Service
public class ClientServiceImpl implements IClientService{
	
	private static final String MESSAGE_REQUIRED_ID_CITY = "The city should be have a id";

	private static final String MESSAGE_CITY_NOT_EXIST = "The city not exist";

	private static final String MESSAGE_CLIENT_NOT_EXIST = "The client not exist";
	
	private static final String MESSAGE_REQUIRED_FULLNAME = "The full name is required";
	
	private static final String MESSAGE_REQUIRED_ID_CLIENT = "The id of client is required";
	
	@Autowired
	private IClientRepository clientRepository;

	@Autowired
	private ICityRepository cityRepository;
	
	@Override
	public Client insert(Client client) {
		
		if (client.getCity().getId() == null) {
			throw new RestException(MESSAGE_REQUIRED_ID_CITY);
		}

		Optional<City> city = null;

		city = cityRepository.findById(client.getCity().getId());

		if (!city.isPresent()) {
			throw new RestException(MESSAGE_CITY_NOT_EXIST);
		}

		client.setCity(city.get());
		return clientRepository.save(client);
	}

	@Override
	public Client findById(String id) {
		if(id == null || id.isEmpty()) {
			throw new RestException(MESSAGE_REQUIRED_ID_CLIENT);
		}
		
		return clientRepository.findById(id).get();
	}

	@Override
	public List<Client> findByName(String name) {
		if(name == null || name.isEmpty()) {
			throw new RestException(MESSAGE_REQUIRED_FULLNAME);
		}
		return clientRepository.findByName(name);
	}

	@Override
	public void delete(String id) {
		if(id == null || id.isEmpty()) {
			throw new RestException(MESSAGE_REQUIRED_ID_CLIENT);
		}
		clientRepository.deleteById(id);
	}

	@Override
	public Client update(String id, @Valid Client client) {
		Optional<Client> clientOld = clientRepository.findById(id);

		if (!clientOld.isPresent()) {
			throw new RestException(MESSAGE_CLIENT_NOT_EXIST);
		}

		clientOld.get().setName(client.getName());

		return clientRepository.save(clientOld.get());
	}

}
