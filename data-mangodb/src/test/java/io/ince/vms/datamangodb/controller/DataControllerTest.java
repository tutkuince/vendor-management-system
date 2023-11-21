package io.ince.vms.datamangodb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ince.vms.datamangodb.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DataController.class)
class DataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DataController mockController;
    private Person person;
    private List<Person> personList;

    private String strPerson;

    @BeforeEach
    void setUp() throws JsonProcessingException {
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

        ObjectMapper objectMapper = new ObjectMapper();
        strPerson = objectMapper.writeValueAsString(person);
    }

    @Test
    void postPerson() throws Exception {
        Mockito.when(mockController.postPerson(person)).thenReturn(ResponseEntity.status(201).build());
        mockMvc.perform(post("/data")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(strPerson)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getPersonById() throws Exception {
        Mockito.when(mockController.getPersonById(person.getId())).thenReturn(ResponseEntity.status(200).build());
        mockMvc.perform(get("/data/{id}", person.getId())
                        .content(person.getId())
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getPersonByNameStartsWith() throws Exception {
        Mockito.when(mockController.getPersonByNameStartsWith("Tutku")).thenReturn(ResponseEntity.status(200).build());
        mockMvc.perform(get("/data?name=Tutku")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getPersonByAgeBetween() throws Exception {
        Mockito.when(mockController.getPersonByAgeBetween(30, 35)).thenReturn(ResponseEntity.status(200).build());
        mockMvc.perform(get("/data/age?minAge={0}&maxAge={1}", 30, 35)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful());
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