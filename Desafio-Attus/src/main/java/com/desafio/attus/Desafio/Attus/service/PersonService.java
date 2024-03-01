package com.desafio.attus.Desafio.Attus.service;
import com.desafio.attus.Desafio.Attus.model.Address;
import com.desafio.attus.Desafio.Attus.model.Person;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class PersonService {
    private Map<String, Person> personMap = new HashMap<>();

    public Person createPerson(String id, String fullName, Date dateOfBirth) {
        Person person = new Person(id, fullName, dateOfBirth);
        personMap.put(id, person);
        return person;
    }

    public Person getPerson(String id) {
        return personMap.get(id);
    }

    public void updatePerson(Person updatedPerson) {
        personMap.put(updatedPerson.getId(), updatedPerson);
    }

    public void deletePerson(String id) {
        personMap.remove(id);
    }

    public Address createAddress(String personId, String id, String street, String cep, String state) {
        Person person = personMap.get(personId);
        if (person != null) {
            Address address = new Address(id, street, cep, state);
            person.addAddress(address);
            return address;
        }
        return null;
    }

    public void updateAddress(String personId, Address updatedAddress) {
        Person person = personMap.get(personId);
        if (person != null) {
            person.getAddresses().removeIf(address -> address.getId().equals(updatedAddress.getId()));
            person.addAddress(updatedAddress);
        }
    }

    public void deleteAddress(String personId, String addressId) {
        Person person = personMap.get(personId);
        if (person != null) {
            person.removeAddress(addressId);
        }
    }
}