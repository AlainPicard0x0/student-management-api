package com.alain.student_management_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    // Handle PUT requests at route: api/student{studentId} (Find student by their id and update the fields provided).
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id, @RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName, @RequestParam(required = false) String email, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dob) {
        studentService.updateStudent(id, firstName, lastName, email, dob);
    }
}
