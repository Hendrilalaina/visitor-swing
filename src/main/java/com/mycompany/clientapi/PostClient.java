/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clientapi;

/**
 *
 * @author Hendrilalaina
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mycompany.entity.Visitor;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PostClient {
    
    public static void main(String[] args) {
        String apiUrl = "http://localhost:8080/api/visitors"; // Your API endpoint
        Client client = Client.create();
        WebResource webResource = client.resource(apiUrl);

        // Example: JSON data to send
        Visitor visitor = new Visitor();
        visitor.setName("Baby");
        visitor.setNumberOfDay(8);
        visitor.setPrice(90.0);
        
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        try {
            String json = objectWriter.writeValueAsString(visitor);
//            System.out.println(json);
            ClientResponse response = webResource
                .type("application/json") // Set content type
                .post(ClientResponse.class, json);
            if (response.getStatus() == 200) { // 201 Created
            	System.out.println("Data posted successfully!");
            } else {
            	System.err.println("Error: " + response.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Make a POST request

        
    }
}

