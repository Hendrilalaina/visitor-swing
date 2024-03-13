package com.mycompany.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mycompany.clientapi.ClientAPI;
import com.mycompany.entity.Visitor;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientController {
    public Visitor getVisitor(Long id) {
        String apiUrl = "http://localhost:8080/api/visitors/" + id.toString();
        Client client = Client.create();
        WebResource webResource = client.resource(apiUrl);
        ClientResponse response = webResource
            .accept("application/json")
            .get(ClientResponse.class);
        Visitor visitor = new Visitor();
        if (response.getStatus() == 200) {
            String responseBody = response.getEntity(String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                visitor = objectMapper.readValue(responseBody, new TypeReference<Visitor>() {});                
            } catch (JsonProcessingException ex) {
                Logger.getLogger(ClientAPI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.err.println("Error: " + response.getStatus());
        }
        return visitor;
    }
    
    public List<Visitor> getVisitors() {
        String apiUrl = "http://localhost:8080/api/visitors";
        Client client = Client.create();
        WebResource webResource = client.resource(apiUrl);
        List<Visitor> visitors = null;
        ClientResponse response = webResource
            .accept("application/json")
            .get(ClientResponse.class);
        if (response.getStatus() == 200) {
            String responseBody = response.getEntity(String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                visitors = objectMapper.readValue(responseBody, new TypeReference<List<Visitor>>() {});                
            } catch (JsonProcessingException ex) {
                Logger.getLogger(ClientAPI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.err.println("Error: " + response.getStatus());
        }
        return visitors;
    }
	
	public boolean postVisitor(Visitor visitor) {
            String apiUrl = "http://localhost:8080/api/visitors";
            Client client = Client.create();
            WebResource webResource = client.resource(apiUrl);
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        try {
            String json = objectWriter.writeValueAsString(visitor);
            ClientResponse response = webResource
                .type("application/json")
                .post(ClientResponse.class, json);
            if (response.getStatus() == 200) { 
            	return true;
            } else {
            	return false;
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
		return false;
	}
	
	public boolean putVisitor(Long id, Visitor visitor) {
            String apiUrl = "http://localhost:8080/api/visitors/" + id.toString();
            Client client = Client.create();
            WebResource webResource = client.resource(apiUrl);

            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
            try {
                String json = objectWriter.writeValueAsString(visitor);
                ClientResponse response = webResource
                    .type("application/json")
                    .put(ClientResponse.class, json);
            if (response.getStatus() == 200) {
                    return true;
            } else {
                    return false;
            }
            } catch (JsonProcessingException e) {
                    e.printStackTrace();
            }
            return false;
	}
	
	public boolean deleteVisitor(Long id) {
            String apiUrl = "http://localhost:8080/api/visitors/" + id.toString();
            Client client = Client.create();
            WebResource webResource = client.resource(apiUrl);
		ClientResponse response = webResource
                .delete(ClientResponse.class);

            if (response.getStatus() == 204) {
                return true;
            } else {
                return false;
            }
	}
}
