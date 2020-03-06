package br.com.elias.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;

import br.com.elias.model.Client;
import br.com.elias.model.dto.ClientAlterDTO;
import br.com.elias.service.IClientService;

@RequestMapping("/client")
@RestController
public class ClientController {
	
	@Autowired
	private IClientService clientService;
	
	@PostMapping
	public ResponseEntity<Client> insert(@Valid @RequestBody Client client) {
		Client clientSaved =  clientService.insert(client);
		return new ResponseEntity<>(clientSaved, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Client> findById(@PathVariable String id) {
		Client client = clientService.findById(id);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Client>> findByName(@RequestParam(value = "name", required = false ) String name ) {
		List<Client> client = clientService.findByName(name);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Client> delete(@PathVariable String id) {
		
		try {
			clientService.delete(id);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	  return new ResponseEntity<>(null, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Client> update(@RequestBody @Valid ClientAlterDTO clientAlterDTO, @PathVariable String id){
        Client client = new ModelMapper().map(clientAlterDTO, Client.class);
        return new ResponseEntity<>(clientService.update(id, client), HttpStatus.OK);
    }
}