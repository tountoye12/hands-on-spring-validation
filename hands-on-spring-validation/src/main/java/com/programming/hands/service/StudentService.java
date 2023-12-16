package com.programming.hands.service;
import com.programming.hands.entity.Student;
import com.programming.hands.exception.NotStudentFoundException;
import com.programming.hands.repository.StudentRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public Student save(Student student) {
        return studentRepository.save(student);
    }
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    public Student getStudent(int id) throws NotStudentFoundException {
        Student student = studentRepository.findStudentById(id);
        if(student != null)
            return student;
        else
            throw new NotStudentFoundException("No student with id: " + id);
    }
}
