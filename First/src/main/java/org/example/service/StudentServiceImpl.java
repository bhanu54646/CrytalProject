package org.example.service;

import net.bytebuddy.asm.Advice;
import org.example.Dto.LaptopDto;
import org.example.Dto.StudentDto;
import org.example.model.*;
import org.example.repository.AddressRepository;
import org.example.repository.LaptopRepository;
import org.example.repository.StudentRepository;
import org.example.repository.UserRepository;
import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.mysql.cj.conf.PropertyKey.logger;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;

@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    StudentRepository studentRepository;
    @Value("${successmessage}")
    private List<String> successmessage;
    @Value("${failuremessage}")
    private List<String> failureMessage;
    @Autowired
    LaptopRepository laptopRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<StudentEntity> getStudentById(String firstName) {

        System.out.println("inside service class method");
        log.error("kasfkdsfsl");
        List<StudentEntity> student = studentRepository.findStudentById(firstName);
        System.out.println(student.size());
        try {

            if (student == null || student.isEmpty()) {

                throw new RuntimeException("No details found in db for the student with" + " " + firstName);
            }
        } catch (Exception ex) {
            System.out.println("Error occurred while retrieving student details: " + ex.getMessage());
        }
        return student;

    }

    @Override
    public List<String> savestudent(StudentEntity student) {


        try {

            if (student.getFirstName() == null || student.getFirstName().isEmpty()) {
                throw new IllegalArgumentException();
            } else {
                studentRepository.save(student);
            }
        } catch (Exception e) {
            return failureMessage;
        }
        //String message = "";
//        if (student.getFirstName() == null || student.getFirstName().isEmpty()) {
//            //message="data not saved";
//            //System.out.println("please enter first name"+" "+message);
//            return failureMessage;
//        } else {
//            studentRepository.save(student);
//            // message="data saved succcesfully";
//             return  successmessage;
//        }
        return successmessage;
    }


    @Override
    public List<String> updateStudent(StudentEntity student) {     // StudentEntity student1=new StudentEntity();
        Optional<StudentEntity> stu = studentRepository.findById(student.getId());
        try {

            if (stu.isPresent()) {
                StudentEntity s = stu.get();
                s.setFirstName(student.getFirstName());
                s.setLastName(student.getLastName());
                studentRepository.save(s);
                return successmessage;
            } else {

                return failureMessage;
            }
        } catch (DataAccessException e) {
            System.out.println("DataAccessException occurred while updating the student: " + e.getMessage());
            return failureMessage;

        }
    }

    @Override
    public List<String> deleteStudent(long id) {
        Optional<StudentEntity> stu = studentRepository.findById(id);
        System.out.println(stu);
        if (stu.isPresent()) {
            StudentEntity student = stu.get();
            studentRepository.delete(student);
            return successmessage;

        } else {

            return failureMessage;

        }


    }

    @Override
    public StudentEntityResponse deleteByName(String firstName) {

        StudentEntityResponse response = new StudentEntityResponse();
        List<StudentEntity> stu = studentRepository.findStudentById(firstName);
        if (stu.isEmpty()) {
            response.setStatuCode("500");
            response.setStatuMessage("failure");
            response.setVersion("v1");
            response.setSr(stu);
            return response;
        } else {

            studentRepository.deleteAll(stu);
            response.setStatuCode("L2004");
            response.setVersion("v2");
            response.setStatuMessage("success");
            response.setSr(stu);
            return response;

        }
//              studentRepository.deleteAll();
//
//        log.debug("hellow no of record delted is this " + " " + x);
//        System.out.println(x);
//        if (x <= 0) {
//            return failureMessage;
//        } else {
//
//            return successmessage;
//        }
    }

    @Override
    public List<Laptop> getStudentwithAllLaptops(long id) {
        StudentEntity su = studentRepository.findStudentById(id);
        List<Laptop> lp = new ArrayList<>();
        System.out.println(su);
        // List<Laptop> lp=new ArrayList<>();
        if (su != null) {
            // for (StudentEntity stu : su) {
            lp = laptopRepository.getAllLaptopsByStudentId(su.getId());

            //System.out.println("naflkaf"+lp);
//                lp.getId();
//                lp.getBrand();
//                lp.getModel();
//                lp.getRam();
//                lp.getPrice();
//                lp.getProcessor();

            return lp;
        } else {

            return lp;
        }
    }


    @Override
    public List<StudentDto> getsomedetails(long id) {
        List<StudentEntity> stu = studentRepository.findStudent(id);
        List<StudentDto> lis = new ArrayList<>();
        System.out.println(lis);
        StudentDto dto = new StudentDto();
        System.out.println(dto);
        if (stu != null) {
            for (StudentEntity stud : stu) {
                String name = stud.getFirstName();
                int age = stud.getAge();
                String email = stud.getEmail();
                System.out.println(stud);
                dto.setFirstName(name);
                dto.setAge(age);
                dto.setEmail(email);
                dto.setStatuscode("l2001");
                dto.setMessage("ssucess");
            }
            lis.add(dto);

            System.out.println(lis.size());
            return lis;

        } else {

            return lis;
        }
    }

    @Override
    public String userService(User user) {

        userRepository.save(user);

        return "SUCESS";
    }

    @Override
    public String addressservice(Address address) {

        addressRepository.save(address);

        return "SUCESS";
    }

    @Override
    public String addUserWithAdresses(User user) {
        List<Address> address = user.getAdr();
        for (Address adr : address) {
            addressRepository.save(adr);
        }
        userRepository.save(user);


        //System.out.println(user);
        //userRepository.save(user);

//        List<Address> ad = user.getAdr();
//        System.out.println(user);
//        userRepository.save(user);

        return "useraddesd";
    }

    @Override
    public String addStudentWithLaptops(StudentEntity student) {
        System.out.println(student);
        List<Laptop> lau = student.getLap();
        for (Laptop la : lau) {
            laptopRepository.save(la);
        }
        studentRepository.save(student);

        return "fa";
    }

    @Override
    public List<LaptopDto> getLaptopiwithstudent(long id) {

        List<LaptopDto> dto = new ArrayList<>();


        //System.out.println(ls);

        System.out.println(dto.size());
        List<Laptop> lap = laptopRepository.getAllLaptopsByStudentId(id);
        for (Laptop l : lap) {
            LaptopDto ls = new LaptopDto();
            ls.setBrand(l.getBrand());
            ls.setModel(l.getModel());
            ls.setRam(l.getRam());
            ls.setProcessor(l.getProcessor());

            dto.add(ls);
        }
        // System.out.println(ls);

        return dto;
    }
}
