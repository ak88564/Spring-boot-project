package com.shredder.studentws.service;

import com.shredder.studentws.entity.StudentEntity;
import com.shredder.studentws.model.StudentCreateRequest;
import com.shredder.studentws.repository.StudentRepository;
//import com.shredder.studentws.repository1.StudentRepository1;
//import com.shredder.studentws.repository1.StudentRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
   // StudentRepository studentRepository;

    public void createUser(StudentCreateRequest request){

        if(request.getName().equals("")) throw new RuntimeException("hrfhrfhrf");

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(request.getName());
        studentEntity.setDob(request.getDob());
        studentEntity.setStd(request.getStd());

        studentRepository.save(studentEntity);
    }

    public StudentEntity getUserByID (Long userID){

        Optional<StudentEntity> studentOptional = studentRepository.findById(userID);
        return studentOptional.orElseGet(StudentEntity::new);
    }


    public StudentEntity getUserByName (String userName)
    {
        Optional<StudentEntity> studentOptional =studentRepository.findByName(userName);
        return studentOptional.orElseGet(StudentEntity::new);
    }

    public String deleteStudent(long userID)
    {
        studentRepository.deleteById(userID);
        return "Student details deleted"+userID;
    }

    public String deleteStudents()
    {
        studentRepository.deleteAll();
        return "All student details deleted";
    }

    public List<StudentEntity> findAll()
    {
        return (List<StudentEntity>) studentRepository.findAll();
    }

}
