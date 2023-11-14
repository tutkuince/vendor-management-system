package io.ince.vms.datamangodb.service;

import io.ince.vms.datamangodb.model.Person;

import java.util.Optional;

public interface IDataService {
    Person save(Person person);
    Optional<Person> findPersonById(String id);
}
