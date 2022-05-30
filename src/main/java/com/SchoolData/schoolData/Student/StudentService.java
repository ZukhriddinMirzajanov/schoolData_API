package com.SchoolData.schoolData.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudent {
    StudentRepository studentrepo;
    @Autowired
    public StudentService(StudentRepository studentrepo) {
        this.studentrepo = studentrepo;
    }
    @Override
    public List<Student> getAllStudents() {
        // TODO Auto-generated method stub
        return studentrepo.findAll();
    }
    @Override
    public Optional<Student> findById(Long id) {
        // TODO Auto-generated method stub
        return studentrepo.findById(id);
    }
    @Override
    public Optional<Student> findByEmail(String email) {
        // TODO Auto-generated method stub
        return studentrepo.findByEmail(email);
    }
    @Override
    public Student save(Student std) {
        // TODO Auto-generated method stub
        return studentrepo.save(std);
    }
    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        studentrepo.deleteById(id);
    }
}
