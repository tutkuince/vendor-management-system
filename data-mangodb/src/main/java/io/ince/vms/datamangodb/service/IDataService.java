package io.ince.vms.datamangodb.service;

import io.ince.vms.datamangodb.model.Person;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IDataService {
    Person save(String id, Person person);
    Optional<Person> findPersonById(String id);
    List<Person> getPersonByNameStartsWith(String name);
    List<Person> findAllByAgeBetween(Integer minAge, Integer maxAge);
    Page<Person> findAll(Integer pageNumber, Integer size);
    void deleteById(String id);
}
