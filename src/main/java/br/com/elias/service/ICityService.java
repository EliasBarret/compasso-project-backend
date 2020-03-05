package br.com.elias.service;

import br.com.elias.model.City;

public interface ICityService {

	public City save(City city);

	public City findByName(String name);

	public City findByState(String state);

}
