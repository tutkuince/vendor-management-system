package io.ince.vms.datamangodb.controller;

import io.ince.vms.datamangodb.constants.Constants;
import io.ince.vms.datamangodb.model.Person;
import io.ince.vms.datamangodb.service.IDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {
    private final IDataService iDataService;

    public DataController(IDataService iDataService) {
        this.iDataService = iDataService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postPerson(@RequestBody Person person) {
        try {
            Person savedPerson = iDataService.save(person);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(Constants.DATA_ERROR);
        }
    }
}
