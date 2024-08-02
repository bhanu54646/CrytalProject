package org.example.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="laptop_entity")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "laptop_id")
    private Long id;
    @Column(name = "laptop_brand")
    private String brand;
    @Column(name = "laptop_model")
    private String model;
    @Column(name = "laptop_price")
    private double price;
    @Column(name = "laptop_ram")
    private int ram;
    @Column(name = "laptop_processor")
    private String processor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id") // Adjust the column name as per your database schema
    private StudentEntity student;
//    private StudentEntity student;
//    @JoinColumn(name = "student_id")
//    public StudentEntity getStudent() {
//        return student;
//    }

//    public void setStudent(StudentEntity student) {
//        this.student = student;
//    }


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "student_id")
//    private StudentEntity student;

    // Constructors
    public Laptop() {
    }

    public Laptop(Long id, String brand, String model, double price, int ram, String processor) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.ram = ram;
        this.processor = processor;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getProcessor() {
        return processor;
    }

//    public Set<StudentEntity> getStudent() {
//        return student;
//    }
//
//    public void setStudent(Set<StudentEntity> student) {
//        this.student = student;
//    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", ram=" + ram +
                ", processor='" + processor + '\'' +
                ", student=" + student +
                '}';
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
}
    // toString() method for logging and debugging
//    @Override
//    public String toString() {
//        return "Laptop{" +
//                "id=" + id +
//                ", brand='" + brand + '\'' +
//                ", model='" + model + '\'' +
//                ", price=" + price +
//                ", ram=" + ram +
//                ", processor='" + processor + '\'' +
//                '}';
//    }

