package com.desafio.attus.Desafio.Attus.model;

public class Address {
    private String id;
    private String street;
    private String cep;
    private String state;

    // Constructor
    public Address(String id, String street, String cep, String state) {
        this.id = id;
        this.street = street;
        this.cep = cep;
        this.state = state;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}