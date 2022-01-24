package com.example.restservice;

import com.fasterxml.jackson.databind.JsonNode;

public class Greeting {

	private  final long id;
	private  final String firstName;
	private final  String lastName;
	private final String email;
	private final String gender;
	private final String ip_address;

	public Greeting(long id, String firstName,String lastName,String email,String gender,String ip_address){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.ip_address = ip_address;

	}
	public Greeting(JsonNode jsonNode){
		   this(jsonNode.get("id").asLong(),jsonNode.get("first_name").asText(),jsonNode.get("last_name").asText(),jsonNode.get("email").asText(),jsonNode.get("gender").asText(), jsonNode.get("ip_address").asText());
	}



	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getGender() {
		return gender;
	}
	public String getIp_address() {
		return ip_address;
	}
}
