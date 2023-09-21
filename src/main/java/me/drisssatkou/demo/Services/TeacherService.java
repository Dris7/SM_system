package me.drisssatkou.demo.Services;

import me.drisssatkou.demo.Repositories.TeacherRepository;
import me.drisssatkou.demo.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    TeacherRepository teacherRepository;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Boolean addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
        return true;
    }
    public Boolean deleteTeacher(int id) {
        teacherRepository.deleteById(id);
        return true;
    }

    public List< Teacher > getTeachers() {
        return teacherRepository.findAll();
    }

    public Boolean updateTeacher(int id, Teacher teacher) {
        teacherRepository.save(teacher);
        return true;
    }

}
