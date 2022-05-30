package com.SchoolData.schoolData.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    StudentService studentservice;
    @Autowired
    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }
    @GetMapping(value="/students")
    public List<Student> getAllStudents(){
        return studentservice.getAllStudents();
    }
    @GetMapping(value="/students/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        Student std = studentservice.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Student with "+id+" is Not Found!"));
        return std;
    }
    @PostMapping(value="/students")
    public Student addStudent(@Valid @RequestBody Student std) {
        return studentservice.save(std);
    }
    @PutMapping(value="/students/{id}")
    public Student updateStudent(@PathVariable("id") Long id, @Valid @RequestBody Student newstd) {
        Student stdu = studentservice.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Student with "+id+" is Not Found!"));
        stdu.setFullName(newstd.getFullName());
        stdu.setEmail(newstd.getEmail());
        return studentservice.save(stdu);
    }
    @DeleteMapping(value="/students/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        Student std = studentservice.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Student with "+id+" is Not Found!"));
        studentservice.deleteById(std.getId());
        return "Student with ID :"+id+" is deleted";
    }
}
