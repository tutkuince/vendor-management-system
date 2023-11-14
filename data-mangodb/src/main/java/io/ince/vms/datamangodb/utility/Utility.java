package io.ince.vms.datamangodb.utility;

import io.ince.vms.datamangodb.model.Person;

public class Utility {
    public static Person buildPerson(String id, Person updatedPerson, Person originalPerson) {
        return Person.builder()
                .id(id)
                .name(updatedPerson.getName() != null ? updatedPerson.getName() : originalPerson.getName())
                .address(updatedPerson.getAddress() != null ? updatedPerson.getAddress() : originalPerson.getAddress())
                .city(updatedPerson.getCity() != null ? updatedPerson.getCity() : originalPerson.getCity())
                .state(updatedPerson.getState() != null ? updatedPerson.getState() : originalPerson.getState())
                .zipCode(updatedPerson.getZipCode() != null ? updatedPerson.getZipCode() : originalPerson.getZipCode())
                .age(updatedPerson.getAge() != null ? updatedPerson.getAge() : originalPerson.getAge())
                .email(updatedPerson.getEmail() != null ? updatedPerson.getEmail() : originalPerson.getEmail())
                .build();
    }
}
