package io.ince.vms.datamangodb.controller;

import io.ince.vms.datamangodb.constants.Constants;
import io.ince.vms.datamangodb.model.Person;
import io.ince.vms.datamangodb.service.IDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
public class DataController {
    private final IDataService iDataService;

    public DataController(IDataService iDataService) {
        this.iDataService = iDataService;
    }

    @PostMapping()
    public ResponseEntity<?> postPerson(@RequestBody Person person) {
        try {
            Person savedPerson = iDataService.save(person);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Constants.DATA_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable String id) {
        try {
            Optional<Person> optionalPerson = iDataService.findPersonById(id);
            if (optionalPerson.isPresent()) {
                return ResponseEntity.status(HttpStatus.OK).body(optionalPerson.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constants.DATA_NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Constants.GET_DATA_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity<?> getPersonByNameStartsWith(@RequestParam String name) {
        try {
            List<Person> personList = iDataService.getPersonByNameStartsWith(name);
            if (!personList.isEmpty())
                return ResponseEntity.status(HttpStatus.OK).body(personList);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constants.DATA_NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Constants.GET_DATA_ERROR);
        }
    }

    @GetMapping("/age")
    public ResponseEntity<?> getPersonByAgeBetween(@RequestParam Integer minAge, @RequestParam Integer maxAge) {
        try {
            List<Person> personList = iDataService.findAllByAgeBetween(minAge, maxAge);
            if (!personList.isEmpty())
                return ResponseEntity.status(HttpStatus.OK).body(personList);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constants.DATA_NOT_FOUND);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Constants.GET_DATA_ERROR);
        }
    }


}
