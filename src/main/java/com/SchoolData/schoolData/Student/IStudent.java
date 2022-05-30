package com.SchoolData.schoolData.Student;

import java.util.List;
import java.util.Optional;

public interface IStudent {
    List<Student> getAllStudents();
    Optional<Student> findById(Long id);
    Optional<Student> findByEmail(String email);
    Student save(Student std);
    void deleteById(Long id);
}
