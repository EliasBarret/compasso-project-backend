package br.com.elias.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

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
import br.com.elias.model.Client;
import br.com.elias.service.IClientService;



@RunWith(SpringRunner.class)
@WebMvcTest(value = ClientController.class)
public class ClientControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IClientService clientService;
	
	@Test
	public void saveClient() throws Exception {
		Client clientMock = new Client();
		
		clientMock.setName("Elias Barreto");
		clientMock.setGender("Masculino");
		clientMock.setBirthday(new Date());
		clientMock.setCity(new City( "Olinda", "PE"));
		
		Mockito.when(clientService.insert(Mockito.any(Client.class))).thenReturn(clientMock);
		
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/client")
			      .content(asJsonString(clientMock))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isCreated());
		
	}
	
	
	@Test
	public void updateNameOfClient() throws Exception {
		Client clientMock = new Client();
		
		clientMock.setName("Elias Barreto Ferreira Filho");
		
		Mockito.when(clientService.insert(Mockito.any(Client.class))).thenReturn(clientMock);
		
		mockMvc.perform( MockMvcRequestBuilders
			      .put("/client/{id}", 1)	
			      .content(asJsonString(clientMock))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	public void delete() throws Exception {
		
		mockMvc.perform( MockMvcRequestBuilders
			      .delete("/client/{id}", 1))	
			      .andExpect(status().isOk());
		
	}
	
	@Test
	public void findById() throws Exception {
		
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/client/{id}", 1)
				  .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
		
	}
	
	@Test
	public void findByName() throws Exception {
		
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/client")
			      .param("name", "Elias")
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