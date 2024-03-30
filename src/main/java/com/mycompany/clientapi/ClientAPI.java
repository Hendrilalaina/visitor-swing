/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clientapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.entity.Visitor;
/**
 *
 * @author Hendrilalaina
 */
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientAPI {
    public static void main(String[] args) {
        String apiUrl = "http://localhost:8080/api/min-max/minimal-total";
        //
        Client client = Client.create();
        WebResource webResource = client.resource(apiUrl);

        // Example: GET request
        ClientResponse response = webResource
                .accept("application/json")
                .get(ClientResponse.class);

        if (response.getStatus() == 200) {
            String responseBody = response.getEntity(String.class);
            System.out.println(responseBody);
//            ObjectMapper objectMapper = new ObjectMapper();
//            try {
//                List<Visitor> visitors = objectMapper.readValue(responseBody, new TypeReference<List<Visitor>>() {});
//                for (Visitor visitor : visitors ){
//                    System.out.println(visitor.getId() + " "+ visitor.getName() + " " + visitor.getNumberOfDay() + " " + visitor.getPrice());
//                }
//            } catch (JsonProcessingException ex) {
//                Logger.getLogger(ClientAPI.class.getName()).log(Level.SEVERE, null, ex);
//            }
        } else {
            System.err.println("Error: " + response.getStatus());
        }
    }
}
