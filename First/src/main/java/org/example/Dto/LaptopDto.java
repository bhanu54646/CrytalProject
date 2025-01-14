package org.example.Dto;

import org.example.model.StudentEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LaptopDto {


    private String brand;
    private String model;
    private int ram;
    private double price;
    private StudentEntity stu;
    private String processor;

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public LaptopDto()
    {}
    public LaptopDto(String brand, String model, int ram, double price, StudentEntity stu) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.price = price;
        this.stu = stu;
    }





    @Override
    public String toString() {
        return "LaptopDto{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                ", price=" + price +
                ", stu=" + stu +
                '}';
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StudentEntity getStu() {
        return stu;
    }

    public void setStu(StudentEntity stu) {
        this.stu = stu;
    }









}
