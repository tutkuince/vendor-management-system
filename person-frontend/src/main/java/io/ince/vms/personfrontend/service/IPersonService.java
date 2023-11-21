package io.ince.vms.personfrontend.service;

import io.ince.vms.personfrontend.model.Person;
import org.springframework.http.ResponseEntity;

public interface IPersonService {
    ResponseEntity<Person> postPerson(Person person);
}
