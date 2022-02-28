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

    @GetMapping
    public List<Student> getStudents() {
        return studentService.findStudents();
    }

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Long id) {
        return studentService.findStudent(id);
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

}
