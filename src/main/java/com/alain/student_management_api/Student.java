package com.alain.student_management_api;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

// Use @Table to rename our Student entity to "student" (all lowercase)
@Entity
@Table(name = "student")
public class Student {

    // Identify our id field and auto-generate the value for our db
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Rename firstName field in db
    @Column(name = "first_name")
    private String firstName;

    // Rename lastName field in db
    @Column(name = "last_name")
    private String lastName;

    // Don't need @Column on instance fields below because we are not changing the name of these fields in our database table
    private String email;
    private LocalDate dob;

    @Transient
    private Integer age;

    public Student(Long id, String firstName, String lastName, String email, LocalDate dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
    }

    public Student(String firstName, String lastName, String email, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id = " + id +
                ", firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", email = '" + email + '\'' +
                ", dob = " + dob +
                ", age = " + age +
                '}';
    }
}
