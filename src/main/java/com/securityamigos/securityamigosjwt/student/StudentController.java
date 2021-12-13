package com.securityamigos.securityamigosjwt.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @GetMapping("/")
    public String welcome(){
        return "index";
    }

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Jones"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );

    @GetMapping(path="{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId())).findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " +studentId + " doesn't exist" ));
    }
}
