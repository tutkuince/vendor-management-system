package io.ince.vms.datamangodb.service;

import io.ince.vms.datamangodb.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
class DataServiceImplTest {

    private Person person;
    private List<Person> personList;
    private Page<Person> personPage;

    @MockBean
    private DataServiceImpl mockService;

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
    void save() {
        Mockito.when(mockService.save(person.getId(), person)).thenReturn(person);
        assertEquals(mockService.save(person.getId(), person).getEmail(), "tutku@mail.com");
    }

    @Test
    void findPersonById() {
        if (mockService.findPersonById(person.getId()).isPresent()) {
            Mockito.when(mockService.findPersonById(person.getId()).get()).thenReturn(person);
            assertEquals(mockService.findPersonById(person.getId()).get().getZipCode(), "35590");
        }

    }

    @Test
    void getPersonByNameStartsWith() {
        Mockito.when(mockService.getPersonByNameStartsWith("Tutku")).thenReturn(personList);
        assertEquals(mockService.getPersonByNameStartsWith("Tutku").get(0).getAddress(), "Bostanli");
    }

    @Test
    void findAllByAgeBetween() {
        Mockito.when(mockService.findAllByAgeBetween(30, 35)).thenReturn(personList);
        assertEquals(mockService.findAllByAgeBetween(30, 35).get(0).getName(), "Tutku Ince");
    }

    @Test
    void findAll() {
        personPage = new PageImpl<>(personList);
        Mockito.when(mockService.findAll(0, 4)).thenReturn(personPage);
        assertEquals(mockService.findAll(0, 4).getTotalElements(), 1);
    }

    @Test
    void deleteById() {
        mockService.deleteById("6553ce8d5d279420039a77d9");
        Mockito.verify(mockService).deleteById("6553ce8d5d279420039a77d9");
    }
}