package me.drisssatkou.demo.Controlers;

import me.drisssatkou.demo.Services.TeacherService;
import me.drisssatkou.demo.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController @RequestMapping("/api/v1/teacher")
public class TeacherController {
    TeacherService teacherService;
    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getTeachers() {
        return teacherService.getTeachers();
    }

    @PostMapping
    public Map<String ,Boolean> addTeacher(Teacher teacher) {
        if (teacherService.addTeacher(teacher))
            return Map.of("success", true);
        else
            return Map.of("success", false);

    }

    @GetMapping("/{id}/delete")
    public Map<String,Boolean> deleteTeacher(@PathVariable int id) {
        if (teacherService.deleteTeacher(id))
            return Map.of("success", true);
        else
            return Map.of("success", false);
    }



}
