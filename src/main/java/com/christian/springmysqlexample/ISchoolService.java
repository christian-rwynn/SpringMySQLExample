package com.christian.springmysqlexample;

import java.util.List;

public interface ISchoolService {
    List<School> findAll();
    void save(School school);
    void saveAll(Iterable<School> schools);
}
