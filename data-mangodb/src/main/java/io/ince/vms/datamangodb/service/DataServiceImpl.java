package io.ince.vms.datamangodb.service;

import io.ince.vms.datamangodb.model.Person;
import io.ince.vms.datamangodb.repository.DataRepository;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements IDataService {

    private final DataRepository dataRepository;

    public DataServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public Person save(Person person) {
        return dataRepository.save(person);
    }
}
