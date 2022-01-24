package com.example.restservice;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	//private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "lastname") String lastname) throws IOException {

		//return new Greeting(1,"Jeanette","Penddreth","jpenddreth0@census.gov","Female","26.58.193.2");
		ObjectMapper objectMapper = new ObjectMapper();
		String path ="/model.json";
		Greeting greeting = null;

		InputStream inputStream=GreetingController.class.getResourceAsStream(path);
		//ArrayNode arrayNode = (ArrayNode) objectMapper.readTree(jsonStr);

		ArrayNode arrayNode = (ArrayNode)  objectMapper.readTree(inputStream);
		if(arrayNode.isArray()) {
			for(JsonNode jsonNode : arrayNode) {
				if (lastname.equals(jsonNode.get("last_name").asText()))
				{
					 greeting = new Greeting(jsonNode);
				}
			}
		}
		return greeting;
	}
}
