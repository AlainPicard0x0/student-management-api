package com.alain.student_management_api;

import javax.persistence.*;
import java.time.LocalDate;

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


}
