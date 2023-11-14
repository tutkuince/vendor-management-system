package io.ince.vms.datamangodb.repository;

import io.ince.vms.datamangodb.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends MongoRepository<Person, String> {
}
