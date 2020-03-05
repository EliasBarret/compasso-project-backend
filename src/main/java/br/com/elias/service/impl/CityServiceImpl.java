package br.com.elias.service.impl;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elias.model.City;
import br.com.elias.repository.ICityRepository;
import br.com.elias.service.ICityService;

@Service
@Transactional
public class CityServiceImpl implements ICityService {

	@Autowired
	private ICityRepository cityRepository;

	@Override
	public City save(City city) {
		return cityRepository.save(city);
	}

	@Override
	public City findByName(String name) {
		return cityRepository.findByName(name).get();
	}

	@Override
	public City findByState(String state) {
		return cityRepository.findByState(state).get();
	}

}