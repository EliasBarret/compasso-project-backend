package br.com.elias.service;

import br.com.elias.model.City;
import java.util.List;

public interface ICityService {

	public City save(City city);

	public List<City> findByName(String name);

	public List<City> findByState(String state);

}