package com.christian.springmysqlexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService implements IGenericService<School>{
    private final ISchoolRepository repository;

    public SchoolService(ISchoolRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<School> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(School school) {
        repository.save(school);
    }

    @Override
    public void saveAll(Iterable<School> schools) {
        repository.saveAll(schools);
    }
}
