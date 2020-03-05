package br.com.elias.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "compasso")
public class Client {
	
	@Id
	private String id;
	@NotBlank(message = "The full name can't be empty")
	@NotNull(message = "The full name can't be null")
	private String name;
	//@NotBlank(message = "The gender can't be empty")
	//@NotNull(message = "The gender can't be null")
	private String gender;
	@Past(message = "The birthday can't be a future date")
	//@NotNull(message = "The birthday can't be null")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date birthday;
	//@NotBlank(message = "The gender can't be empty")
	//@NotNull(message = "The gender can't be null")
	private int age;
	@NotNull(message = "The city cant'be be null")
	@DBRef
    private City city;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
