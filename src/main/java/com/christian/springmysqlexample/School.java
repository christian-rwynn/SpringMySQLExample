package com.christian.springmysqlexample;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class School extends AbstractEntity implements Serializable {

    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "school", fetch = EAGER)
    private List<Student> students;

    public School(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public School(String name) {
        this.name = name;
    }

    public School() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
