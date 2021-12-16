package com.christian.springmysqlexample;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student);
    void saveAll(Iterable<Student> students);
}
