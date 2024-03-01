package com.desafio.attus.Desafio.Attus.model;

import java.util.*;

public class Person {
    private String id;
    private String fullName;
    private Date dateOfBirth;
    private List<Address> addresses;
    private String mainAddressId;


    public Person(String id, String fullName, Date dateOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.addresses = new ArrayList<>();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getMainAddressId() {
        return mainAddressId;
    }

    public void setMainAddressId(String mainAddressId) {
        this.mainAddressId = mainAddressId;
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public void removeAddress(String addressId) {
        addresses.removeIf(address -> address.getId().equals(addressId));
    }
}