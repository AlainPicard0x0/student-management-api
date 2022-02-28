package com.alain.student_management_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    // Inject StudentRepository interface so that we can use its methods in our Service class
    @Autowired
    private StudentRepository studentRepository;

    // Method to return list of all students in database
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    // Method to find a single student by their id
    public Student findStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id: " + id + " not found"));
        return student;
    }

    // Method to add new student to database
    public void addStudent(Student student) {
        Optional<Student> optionalStudent = studentRepository.findStudentByEmail(student.getEmail());
        if(optionalStudent.isPresent()) {
            throw new IllegalStateException("Student with that email already in use");
        }
        studentRepository.save(student);
    }

    


}
