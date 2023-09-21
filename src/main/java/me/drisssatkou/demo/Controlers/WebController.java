package me.drisssatkou.demo.Controlers;

import me.drisssatkou.demo.Services.StudentService;
import me.drisssatkou.demo.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

@Controller
public class WebController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/index")
    public String index(Model model) {
        model.addAttribute("students", studentService.getStudents());

        return "index";
    }


    @GetMapping(path = "/addStudent")
    public String addStudent() {

        return "addStudent";
    }
    //make a post request to save a student
    @PostMapping(path = "/saveStudent")
    public String saveStudent(
            @RequestParam String fullname,
            @RequestParam Date dob,
            Model model
    ) {
        Student student = new Student(fullname, dob);
        studentService.addStudent(student);
        model.addAttribute("students", studentService.getStudents());
        return "index";
    }

    @GetMapping(path = "/editStudent/{id}")
    public String editStudent(@PathVariable int id, Model model) {
        model.addAttribute("student_id", id);
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "editStudent";
    }


    @PostMapping(path = "/updateStudent")
    public String updateStudent(@RequestParam int id,
            @RequestParam String fullname,
            @RequestParam Date dob,
            Model model
    ) {
        Student student = new Student(fullname, dob);
        studentService.updateStudent(id, student);
        model.addAttribute("students", studentService.getStudents());
        return "index";
    }


    @GetMapping(path = "/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id, Model model) {
        studentService.deleteStudent(id);
        model.addAttribute("students", studentService.getStudents());
        return "index";
    }


    @PostMapping(path = "/search")
    public String search(@RequestParam String search, Model model) {
        if (!search.equals(""))
             model.addAttribute("students", studentService.getStudentsLike(search));
        else model.addAttribute("students", studentService.getStudents());
        return "table";
    }



}
