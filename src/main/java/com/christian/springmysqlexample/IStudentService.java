package com.christian.springmysqlexample;

import java.util.List;

public interface IStudentService extends IGenericService<Student>{
    List<Student> search(String filterText);
}
