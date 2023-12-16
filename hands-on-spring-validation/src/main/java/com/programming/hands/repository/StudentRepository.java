package com.programming.hands.repository;

import com.programming.hands.entity.Student;
import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {

    Student findStudentById(int id);
}
