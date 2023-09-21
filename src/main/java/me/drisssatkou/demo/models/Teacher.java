package me.drisssatkou.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String fullname ;

    private Date dob ;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses ;


    public Teacher(String fullname, Date dob) {
        this.fullname = fullname;
        this.dob = dob;
    }





}
