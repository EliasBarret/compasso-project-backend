package br.com.elias.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.elias.model.City;
import br.com.elias.service.ICityService;

@RequestMapping("/city")
@RestController
public class CityController {

	@Autowired
	private ICityService cityService;

	@PostMapping
	public ResponseEntity<City> saveCity(@Valid @RequestBody City city) {

		city = cityService.save(city);

		return new ResponseEntity<>(city, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<City> getCityByNameOrState(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "state", required = false) String state) {

		City city = new City();

		if (name != null) {
			city = cityService.findByName(name);
		} else if (state != null) {
			city = cityService.findByState(state);
		}

		return new ResponseEntity<>(city, HttpStatus.OK);
	}

}
