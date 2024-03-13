/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author Hendrilalaina
 */
public class TarifController { 
    public String minimalTarif() {
        String apiUrl = "http://localhost:8080/api/min-max/minimal-total";
        Client client = Client.create();
        WebResource webResource = client.resource(apiUrl);
        ClientResponse response = webResource
                .accept("application/json")
                .get(ClientResponse.class);
        if (response.getStatus() == 200) {
            String responseBody = response.getEntity(String.class);
            return responseBody;
        }else{
            System.err.println("Error");
        }
        return "";
    }
    
    public String maximalTarif() {
        String apiUrl = "http://localhost:8080/api/min-max/maximal-total";
        Client client = Client.create();
        WebResource webResource = client.resource(apiUrl);
        ClientResponse response = webResource
                .accept("application/json")
                .get(ClientResponse.class);
        if (response.getStatus() == 200) {
            String responseBody = response.getEntity(String.class);
            return responseBody;
        }else{
            System.err.println("Error");
        }
        return "";      
    }
    
    public String total() {
        String apiUrl = "http://localhost:8080/api/min-max/total";
        Client client = Client.create();
        WebResource webResource = client.resource(apiUrl);
        ClientResponse response = webResource
                .accept("application/json")
                .get(ClientResponse.class);
        if (response.getStatus() == 200) {
            String responseBody = response.getEntity(String.class);
            return responseBody;
        }else{
            System.err.println("Error");
        }
        return "";
    }
}
