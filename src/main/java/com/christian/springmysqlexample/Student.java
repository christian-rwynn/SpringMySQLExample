package com.christian.springmysqlexample;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Student extends AbstractEntity implements Serializable {

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "school_id")
    public School school;

    public Student(String firstName, String lastName, School school) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student() {
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school){
        this.school = school;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
