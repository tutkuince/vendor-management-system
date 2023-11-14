package io.ince.vms.datamangodb.service;

import io.ince.vms.datamangodb.model.Person;
import io.ince.vms.datamangodb.repository.DataRepository;
import io.ince.vms.datamangodb.utility.Utility;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataServiceImpl implements IDataService {

    private final DataRepository dataRepository;

    public DataServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public Person save(String id, Person person) {
        if (id != null) {
            Optional<Person> dbPerson = findPersonById(id);
            if (dbPerson.isPresent()) {
                Person buildPerson = Utility.buildPerson(id, person, dbPerson.get());
                return dataRepository.save(buildPerson);
            }
            else
                return null;
        } else {
            return dataRepository.insert(person);
        }
    }

    @Override
    public Optional<Person> findPersonById(String id) {
        return dataRepository.findById(id);
    }

    @Override
    public List<Person> getPersonByNameStartsWith(String name) {
        return dataRepository.findPersonByNameStartsWith(name);
    }
    @Override
    public List<Person> findAllByAgeBetween(Integer minAge, Integer maxAge) {
        return dataRepository.findAllByAgeBetween(minAge, maxAge);
    }

    @Override
    public List<Person> findAll() {
        return dataRepository.findAll();
    }
}
