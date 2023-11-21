package io.ince.vms.personfrontend.service;

import io.ince.vms.personfrontend.api.PersonAPI;
import io.ince.vms.personfrontend.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements IPersonService {
    private final PersonAPI personAPI;
    @Autowired
    public PersonServiceImpl(PersonAPI personAPI) {
        this.personAPI = personAPI;
    }

    @Override
    public ResponseEntity<Person> postPerson(Person person) {
        return personAPI.postPerson(person);
    }
}
