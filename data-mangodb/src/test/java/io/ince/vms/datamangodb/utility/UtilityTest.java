package io.ince.vms.datamangodb.utility;

import io.ince.vms.datamangodb.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {

    private Person originalPerson;
    private Person updatedPerson;

    @BeforeEach
    void setUp() {
        originalPerson = Person.builder()
                .id("6553ce8d5d279420039a77d9")
                .name("Tutku Ince")
                .address("Bostanli")
                .city("Izmir")
                .state("Izmir")
                .zipCode("35590")
                .age(34)
                .email("tutku@mail.com")
                .build();

        updatedPerson = Person.builder()
                .name("Cigdem Ince")
                .age(30)
                .email("cigdem@mail.com")
                .build();
    }

    @Test
    void buildPerson() {
        Person updateablePerson = Utility.buildPerson("6553ce8d5d279420039a77d9", updatedPerson, originalPerson);
        assertEquals(updateablePerson.getName(), updatedPerson.getName());
        assertEquals(updateablePerson.getAge(), updatedPerson.getAge());
        assertEquals(updateablePerson.getEmail(), updatedPerson.getEmail());
    }

    @Test
    void obscurerPositive() {
        String ccNumber = "1234123412356784";
        String ccNum = Utility.obscurer(ccNumber);
        assertEquals(ccNum, "XXXXXXXXXXXX6784");
    }

    @Test
    void obscurerNegative() {
        String ccNumber = "12341234";
        String ccNum = Utility.obscurer(ccNumber);
        assertEquals(ccNum, "Invalid Credit Card Number");
    }
}