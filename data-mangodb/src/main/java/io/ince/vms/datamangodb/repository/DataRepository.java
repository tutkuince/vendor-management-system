package io.ince.vms.datamangodb.repository;

import io.ince.vms.datamangodb.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends MongoRepository<Person, String> {
    List<Person> findPersonByNameStartsWith(String name);
}
