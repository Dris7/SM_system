package me.drisssatkou.demo.models;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {

    public Student(String fullname, Date dob) {
        this.fullname = fullname;
        this.dob = dob;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String fullname;
    private Date dob;
    @Transient
    private int age;

    @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
    private List<Course> courses ;

    public int getAge() {
        return LocalDate.now().getYear() - dob.toLocalDate().getYear();
    }

}
