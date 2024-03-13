/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Hendrilalaina
 */
public class Visitor {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("numberOfDay")
    private int numberOfDay;
    @JsonProperty("price")
    private double price;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(int numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
