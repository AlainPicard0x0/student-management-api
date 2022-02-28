package com.alain.student_management_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    // Inject StudentRepository interface so that we can use its methods in our Service class.
    @Autowired
    private StudentRepository studentRepository;

    // Method to return list of all students in database.
    public List<Student> findStudents() {
        return studentRepository.findAll();
    }

    // Method to find a single student by their id.
    public Student findStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id: " + id + " not found"));
        return student;
    }

    // Method to add new student to database.
    public void addStudent(Student student) {

        // Check to see if student being added is using an email that already exists in the database and throw error if true.
        Optional<Student> optionalStudent = studentRepository.findStudentByEmail(student.getEmail());
        if(optionalStudent.isPresent()) {
            throw new IllegalStateException("Student with that email already in use");
        }
        studentRepository.save(student);
    }

    // Method to delete student from database
    public void deleteStudent(Long id) {

        // Check to see if student with id exists. If they don't exist throw error.
        if(!studentRepository.existsById(id)) {
            throw new IllegalStateException("Student with id: " + id + " not found");
        }
        studentRepository.deleteById(id);
    }

    // Method to update student information in database
    // @Transactional used to auto update database anytime value is changed.
    @Transactional
    public void updateStudent(Long id, String firstName, String lastName, String email, LocalDate dob) {

        // Find the student to be updated in the database and if student doesn't exist, throw error.
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id: " + id + " not found"));

        // Check if the firstName being passed in is not null and make sure it isn't the same as the current first name in the database.
        if(firstName != null && !Objects.equals(student.getFirstName(), firstName)) {

            // update the students firstName in database
            student.setFirstName(firstName);
            System.out.println("Student first name updated to: " + firstName + ".");
        }

        // Check if the lastName being passed in is not null and make sure it isn't the same as the current lastName in the database.
        if(lastName != null && !Objects.equals(student.getLastName(), lastName)) {

            // update the students lastName in database.
            student.setLastName(lastName);
            System.out.println("Student last name updated to: " + lastName + ".");
        }

        // Check if the email being passed in is not null and make sure it isn't the same as the current email in the database.
        if(email != null && !Objects.equals(student.getEmail(), email)) {

            // Check to see if the new email address is an email address that already exists in the database and throw error if true.
            Optional<Student> optionalStudent = studentRepository.findStudentByEmail(email);
            if(optionalStudent.isPresent()) {
                throw new IllegalStateException("Email: " + email + " is already in use");
            }

            // Update student email in database.
            student.setEmail(email);
            System.out.println("Student email updated to: " + email + ".");
        }

        // Check if the dob being passed in is not null and make sure it isn't the same as the current dob in the database.
        if(dob != null && !Objects.equals(student.getDob(), dob)) {

            // Update student dob in database.
            student.setDob(dob);
            System.out.println("Student dob updated to: " + dob + ".");
        }
    }
}
