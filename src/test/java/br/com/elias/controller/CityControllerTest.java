package br.com.elias.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.elias.model.City;
import br.com.elias.service.ICityService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CityController.class)
public class CityControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ICityService cityService;
	
	private List<City> mockCity; 

	@Test
	public void insertCity() throws Exception {
		City mockCity = new City( "Recife", "PE");
		Mockito.when(cityService.save(Mockito.any(City.class))).thenReturn(mockCity);
		
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/city")
			      .content(asJsonString(new City("Recife", "PE")))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated());
	}
	
	@Test
	public void getByName() throws Exception {
		
		Mockito.when(cityService.findByName(Mockito.anyString())).thenReturn(mockCity);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/city")
				.param("name", "Recife")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}
	
	@Test
	public void getByState() throws Exception {
		
		Mockito.when(cityService.findByState(Mockito.anyString())).thenReturn(mockCity);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/city")
				.param("state", "PE")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}
	
	private String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}