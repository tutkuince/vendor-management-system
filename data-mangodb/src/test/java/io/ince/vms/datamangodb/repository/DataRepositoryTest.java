package io.ince.vms.datamangodb.repository;

import io.ince.vms.datamangodb.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class DataRepositoryTest {

    private Person person;
    private List<Person> personList;

    private Page<Person> personPage;

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
        Mockito.when(mockRepository.findAllByAgeBetween(30, 35)).thenReturn(personList);
        assertEquals(mockRepository.findAllByAgeBetween(30, 35).get(0).getAge(), 34);
    }

    @Test
    void findById() {
        if (mockRepository.findById("6553ce8d5d279420039a77d9").isPresent()) {
            Mockito.when(mockRepository.findById("6553ce8d5d279420039a77d9").get()).thenReturn(person);
            assertEquals(mockRepository.findById("6553ce8d5d279420039a77d9").get().getZipCode(),"35590");
        }
    }

    @Test
    void updatePerson() {
        Mockito.when(mockRepository.save(person)).thenReturn(person);
        assertEquals(mockRepository.save(person).getEmail(),"tutku@mail.com");
    }

    @Test
    void insertPerson() {
        Mockito.when(mockRepository.insert(person)).thenReturn(person);
        assertEquals(mockRepository.insert(person).getCity(),"Izmir");
    }

    @Test
    void deletePerson() {
        mockRepository.deleteById("6553ce8d5d279420039a77d9");
        Mockito.verify(mockRepository).deleteById("6553ce8d5d279420039a77d9");
    }

    @Test
    void findAll() {
        Mockito.when(mockRepository.findAll()).thenReturn(personList);
        assertEquals(mockRepository.findAll().get(0).getName(), "Tutku Ince");
    }
}