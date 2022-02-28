package com.alain.student_management_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {

    // Inject StudentService so we can use its methods.
    @Autowired
    private StudentService studentService;

    // Handle GET requests at route: api/student (Return list of all students).
    @GetMapping
    public List<Student> getStudents() {
        return studentService.findStudents();
    }

    // Handle GET requests at route: api/student/{studentId} (Find individual student by their id).
    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Long id) {
        return studentService.findStudent(id);
    }

    // Handle POST requests at route: api/student (Create new student and Save to database).
    @PostMapping
    public void addNewStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    // Handle DELETE requests at route: api/student/{studentId} (Find student by their id and Delete student from database).
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }

    // TODO
    // Add update method to controller.

}
