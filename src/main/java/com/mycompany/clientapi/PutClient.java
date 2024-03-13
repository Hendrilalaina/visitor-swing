/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clientapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mycompany.entity.Visitor;
/**
 *
 * @author Hendrilalaina
 */
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PutClient {

    public static void main(String[] args) {
        String apiUrl = "http://localhost:8080/api/visitors/6"; // Your API endpoint (replace with the actual visitor ID)

        Client client = Client.create();
        WebResource webResource = client.resource(apiUrl);

        // Example: JSON data for update
        Visitor visitor = new Visitor();
        visitor.setName("Brad");
        visitor.setNumberOfDay(6);
        visitor.setPrice(87);
        
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        
        String json;
		try {
			json = objectWriter.writeValueAsString(visitor);
	        ClientResponse response = webResource
	                .type("application/json")
	                .put(ClientResponse.class, json);
	        if (response.getStatus() == 200) {
	        	System.out.println("Data updated successfully!");
	        } else {
	        	System.err.println("Error: " + response.getStatus());
	        }
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
    }
}

