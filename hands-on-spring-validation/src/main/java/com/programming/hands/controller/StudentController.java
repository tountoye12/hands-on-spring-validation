package com.programming.hands.controller;


import com.programming.hands.dto.StudentRequest;
import com.programming.hands.entity.Student;
import com.programming.hands.exception.NotStudentFoundException;
import com.programming.hands.service.StudentService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {


    @Autowired
    private StudentService studentService;

//    public StudentController(StudentService studentService){
//        this.studentService =studentService;
//    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody @Valid StudentRequest studentRequest) {
        Student student = new Student(studentRequest.getId(), studentRequest.getName(),
                studentRequest.getEmail(), studentRequest.getGpa());
        return ResponseEntity.ok(studentService.save(student));
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) throws NotStudentFoundException {
        return ResponseEntity.ok(studentService.getStudent(id));
    }










}
