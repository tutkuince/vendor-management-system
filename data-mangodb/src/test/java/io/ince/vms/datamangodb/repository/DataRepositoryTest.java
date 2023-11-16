package io.ince.vms.datamangodb.repository;

import io.ince.vms.datamangodb.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class DataRepositoryTest {

    private Person person;
    private List<Person> personList;

    @MockBean
    private DataRepository mockRepository;

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
    void findPersonByNameStartsWith() {
        Mockito.when(mockRepository.findPersonByNameStartsWith("Tutku")).thenReturn(personList);
        assertEquals(mockRepository.findPersonByNameStartsWith("Tutku").get(0).getName(), "Tutku Ince");
    }

    @Test
    void findAllByAgeBetween() {
    }
}