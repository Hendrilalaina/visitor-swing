/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clientapi;

/**
 *
 * @author Hendrilalaina
 */
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DeleteClient {

    public static void main(String[] args) {
        String apiUrl = "http://localhost:8080/api/visitors/9"; // Your API endpoint (replace with the actual visitor ID)

        Client client = Client.create();
        WebResource webResource = client.resource(apiUrl);

        // Make a DELETE request
        ClientResponse response = webResource
                .delete(ClientResponse.class);

        if (response.getStatus() == 204) { // 204 No Content (successful deletion)
            System.out.println("Data deleted successfully!");
        } else {
            System.err.println("Error: " + response.getStatus());
        }
    }
}
