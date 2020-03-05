package br.com.elias.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClientAlterDTO {
	
	@NotBlank(message = "The full name can't be empty")
	@NotNull(message = "The full name can't be null")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
