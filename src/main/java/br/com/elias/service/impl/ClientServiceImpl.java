package br.com.elias.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elias.Util.Constants;
import br.com.elias.exception.RestException;
import br.com.elias.model.City;
import br.com.elias.model.Client;
import br.com.elias.repository.ICityRepository;
import br.com.elias.repository.IClientRepository;
import br.com.elias.service.IClientService;

@Service
public class ClientServiceImpl implements IClientService{
	
	@Autowired
	private IClientRepository clientRepository;

	@Autowired
	private ICityRepository cityRepository;
	
	@Override
	public Client insert(Client client) {
		
		if (client.getCity().getId() == null) {
			throw new RestException(Constants.ID_CITY_REQUIRED);
		}

		Optional<City> city = null;

		city = cityRepository.findById(client.getCity().getId());

		if (!city.isPresent()) {
			throw new RestException(Constants.CITY_NOT_FOUND);
		}

		client.setCity(city.get());
		return clientRepository.save(client);
	}

	@Override
	public Client findById(String id) {
		if(id == null || id.isEmpty()) {
			throw new RestException(Constants.ID_CLIENT_REQUIRED);
		}
		return clientRepository.findById(id).get();
	}

	@Override
	public List<Client> findByName(String name) {
		if(name == null || name.isEmpty()) {
			throw new RestException(Constants.CLIENT_NAME_REQUARED);
		}
		return clientRepository.findByName(name);
	}

	@Override
	public void delete(String id) {
		if(id == null || id.isEmpty()) {
			throw new RestException(Constants.ID_CLIENT_REQUIRED);
		}
		clientRepository.deleteById(id);
	}

	@Override
	public Client update(String id, @Valid Client client) {
		Optional<Client> clientOld = clientRepository.findById(id);

		if (!clientOld.isPresent()) {
			throw new RestException(Constants.CLIENT_NOT_FOUND);
		}
		clientOld.get().setName(client.getName());
		return clientRepository.save(clientOld.get());
	}
}