package io.ince.vms.datamangodb.repository;

import io.ince.vms.datamangodb.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends MongoRepository<Person, String> {
    List<Person> findPersonByNameStartsWith(String name);

    @Query(value = "{'age':  {$gt: ?0, $lt: ?1}}", fields = "{_id:1, name:1, age:1}")
    List<Person> findAllByAgeBetween(Integer minAge, Integer maxAge);
}
