package me.drisssatkou.demo.Controlers;

import me.drisssatkou.demo.Services.CourseService;
import me.drisssatkou.demo.models.Course;
import me.drisssatkou.demo.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController @RequestMapping("/api/v1/course")
public class CourseController {

    CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @PostMapping
    public Map<String ,Boolean> addCourse(Course course) {
        if (courseService.addCourse(course))
            return Map.of("success", true);
        else
            return Map.of("success", false);

    }
    @GetMapping("/{id}/delete")
public Map<String,Boolean> deleteCourse(@PathVariable int id) {
        if (courseService.deleteCourse(id))
            return Map.of("success", true);
        else
            return Map.of("success", false);
    }

    


}
