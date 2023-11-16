package io.ince.vms.datamangodb.utility;

import io.ince.vms.datamangodb.model.Person;
import org.springframework.util.StringUtils;

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

    public static String obscurer(String ccNumber) {
        if (ccNumber.length() > 16 || ccNumber.length() < 12) {
            return "Invalid Credit Card Number";
        }
        String ccObscurer = "";
        for (int i = 0; i < ccNumber.length() - 4; i++) {
            ccObscurer += "X";
        }
        ccObscurer += ccNumber.substring(ccNumber.length() - 4);
        return ccObscurer;
    }
}
