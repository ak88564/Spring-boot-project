package com.shredder.studentws.contoller;


import com.shredder.studentws.entity.StudentEntity;
import com.shredder.studentws.model.StudentCreateRequest;
import com.shredder.studentws.repository.StudentRepository;
import com.shredder.studentws.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
//    SOLID
    @Autowired
    StudentService studentService;


    @PostMapping("/api/v1/student")
    public ResponseEntity<String> createStudent(@RequestBody StudentCreateRequest studentCreateRequest){

        studentService.createUser(studentCreateRequest);

        return ResponseEntity.ok("Created");
    }

    @GetMapping("/api/v1/student/{userid}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Long userid)
    {

        return ResponseEntity.ok(studentService.getUserByID(userid));
    }

    @GetMapping("/api/v1/student")
    public ResponseEntity<StudentEntity> getStudentByName(@RequestParam(value="name")String name)
    {
       return ResponseEntity.ok(studentService.getUserByName(name));

    }

    @DeleteMapping("/api/v1/student/delete/{userid}")
    public String deleteStudent(@PathVariable long userid)
    {
        return studentService.deleteStudent(userid);
    }

    @DeleteMapping("/api/v1/student/deleteAll")
    public String deleteStudents()
    {
        studentService.deleteStudents();
        return "All details deleted";
    }

    @GetMapping("/api/v1/studentFindAll")
    public ResponseEntity <List<StudentEntity>> findAll()
    {
        return ResponseEntity.ok(studentService.findAll());
    }

}
