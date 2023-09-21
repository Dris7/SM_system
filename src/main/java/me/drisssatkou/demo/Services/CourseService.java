package me.drisssatkou.demo.Services;

import me.drisssatkou.demo.Repositories.CourseRepository;
import me.drisssatkou.demo.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    CourseRepository courseRepository;
    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Boolean addCourse(Course course) {
        courseRepository.save(course);
        return true;
    }
    public Boolean deleteCourse(int id) {
        courseRepository.deleteById(id);
        return true;
    }
    public Boolean updateCourse(int id, Course course) {
        courseRepository.save(course);
        return true;
    }
    public Course getCourse(int id) {
        return courseRepository.findById(id).get();
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public List<Course> getCoursesByIds(List <Integer> ids) {
        return courseRepository.findAllById(ids);
    }


}
