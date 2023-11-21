package io.ince.vms.personfrontend.api;

import io.ince.vms.personfrontend.constants.Constants;
import io.ince.vms.personfrontend.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PersonAPI {
    private final RestTemplate restTemplate;
    @Autowired
    public PersonAPI(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public ResponseEntity<Person> postPerson(Person person) {
        return restTemplate.postForEntity(Constants.POST_URL, person, Person.class);
    }
}
