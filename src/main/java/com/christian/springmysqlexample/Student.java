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
}
