package org.example.service;

import org.example.Dto.LaptopDto;
import org.example.Dto.StudentDto;
import org.example.model.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StudentService {
    public List<StudentEntity> getStudentById(String name);

    public List<String> savestudent(StudentEntity student);

    public List<String> updateStudent(StudentEntity student);

    public List<String> deleteStudent(long id);

    public StudentEntityResponse deleteByName(String firstName);

    public List<Laptop> getStudentwithAllLaptops(long id);

    public List<StudentDto> getsomedetails(long id);

    public String  userService(User user);
    public String addressservice(Address address);

    public String addUserWithAdresses(User user);

    public String addStudentWithLaptops(StudentEntity student);

    public  List<LaptopDto> getLaptopiwithstudent(long id);
}