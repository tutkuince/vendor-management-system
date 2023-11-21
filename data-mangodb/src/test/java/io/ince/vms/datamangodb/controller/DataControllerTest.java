package io.ince.vms.datamangodb.controller;

import io.ince.vms.datamangodb.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DataController.class)
class DataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DataController dataController;
    private Person person;
    private List<Person> personList;

    @BeforeEach
    void setUp() {
        person = Person.builder()
                .id("6553ce8d5d279420039a77d9")
                .name("Tutku Ince")
                .address("Bostanli")
                .city("Izmir")
                .state("Izmir")
                .zipCode("35590")
                .age(34)
                .email("tutku@mail.com")
                .build();

        personList = new ArrayList<>();
        personList.add(person);
    }

    @Test
    void postPerson() {
        
    }

    @Test
    void getPersonById() {
    }

    @Test
    void getPersonByNameStartsWith() {
    }

    @Test
    void getPersonByAgeBetween() {
    }

    @Test
    void findAll() {
    }

    @Test
    void updateById() {
    }

    @Test
    void deleteById() {
    }
}