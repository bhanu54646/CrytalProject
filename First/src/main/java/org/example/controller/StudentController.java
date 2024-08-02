package org.example.controller;


import org.example.Dto.LaptopDto;
import org.example.Dto.StudentDto;
import org.example.model.*;
import org.example.service.StudentService;
import org.example.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping("/First")
@RestController
public class StudentController {
    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/getstudent/v1/{firstName}")
    public List<StudentEntity> getStudentById(@PathVariable String firstName) {

        System.out.println("INSIDE CONTROLLER");
        return studentService.getStudentById(firstName);
    }

    @PostMapping("/save/student")
    public List<String> saveStudent(@RequestBody StudentEntity student) {
        return studentService.savestudent(student);

    }

    @PutMapping("/update/student")
    public List<String> updateStudent(@RequestBody StudentEntity student) {

        return studentService.updateStudent(student);

    }

    @DeleteMapping("/delete/student/{id}")
    public List<String> deleteStudent(@PathVariable long id) {

        return studentService.deleteStudent(id);
    }

    @DeleteMapping("/delete/student-by-name/{firstName}")
    public StudentEntityResponse deleteByFirstName(@PathVariable String firstName) {
        return studentService.deleteByName(firstName);

    }

    @GetMapping("/getall-laptops-Withstudent/{id}")
    public List<Laptop> GetStudentwithLaptops(@PathVariable long id) {
        return studentService.getStudentwithAllLaptops(id);
    }

    @GetMapping("/get-someDetails/{id}")
    public List<StudentDto> getSomedetailsfromStudent(@PathVariable long id) {
        return studentService.getsomedetails(id);
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user) {

        System.out.println("inside controller");
        return studentService.userService(user);

    }

    @PostMapping("/creatAdress")
    public String createaddress(@RequestBody Address address) {

        System.out.println("inside controller");
        return studentService.addressservice(address);

    }

    @PostMapping("/users/save-with-addresss")
    public String addUserWithAdresses(@RequestBody User user) {
        return studentService.addUserWithAdresses(user);
    }

    @PostMapping("/student/add/laptopwithstudents")
    public String addStudentWithLaptops(@RequestBody StudentEntity student) {

        return studentService.addStudentWithLaptops(student);

    }

    @GetMapping("/get/All-LaptopsWithStudent/{id}")
    public List<LaptopDto> getLaptopiwithstudent(@PathVariable long id) {

        return studentService.getLaptopiwithstudent(id);
    }


}








