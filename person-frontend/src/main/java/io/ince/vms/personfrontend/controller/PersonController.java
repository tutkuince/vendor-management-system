package io.ince.vms.personfrontend.controller;

import io.ince.vms.personfrontend.model.Person;
import io.ince.vms.personfrontend.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Slf4j
public class PersonController {
    private final IPersonService personService;
    @Autowired
    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public String getPerson() {
        return "index";
    }

    @PostMapping(value = "/person")
    public String postPerson(@RequestBody Person person) {
        ResponseEntity<Person> personResponse = personService.postPerson(person);
        log.info("Person => {}", personResponse);
        return "index";
    }
}
