package me.drisssatkou.demo.Controlers;

import me.drisssatkou.demo.Services.CourseService;
import me.drisssatkou.demo.Services.StudentService;
import me.drisssatkou.demo.models.Course;
import me.drisssatkou.demo.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/student")
public class StudentControler {
    private StudentService studentService;
    private CourseService courseService;

    @Autowired
    public StudentControler(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public Map<String,Boolean> addStudent(@RequestBody Student student) {
        if (studentService.addStudent(student))
            return Map.of("success", true);
        else
            return Map.of("success", false);
    }

    @PostMapping("/{id}/addCourse")
    public Map<String,Boolean> addCourseToStudent(@PathVariable int id , @RequestBody List <Integer> Courses_ids) {
        List <Course> courses = courseService.getCoursesByIds(Courses_ids);
        System.out.println("the size of list is "+courses.size());
        if (studentService.addCourseToStudent(id , courses))
            return Map.of("success", true);
        else
            return Map.of("success", false);
     }


     @DeleteMapping("/{id}/delete")
        public Map<String,Boolean> deleteStudent(@PathVariable int id) {
            if (studentService.deleteStudent(id))
                return Map.of("success", true);
            else
                return Map.of("success", false);
        }

     @PutMapping("/{id}/update")
        public Map<String,Boolean> updateStudent(@PathVariable int id , @RequestBody Student student) {
            if (studentService.updateStudent(id , student))
                return Map.of("success", true);
            else
                return Map.of("success", false);
        }




}
