package me.drisssatkou.demo.Services;

import me.drisssatkou.demo.Repositories.StudentRepository;
import me.drisssatkou.demo.models.Course;
import me.drisssatkou.demo.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService {
    StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Boolean addStudent(Student student) {
        studentRepository.save(student);
        return true;
    }

    public Boolean deleteStudent(int id) {
        studentRepository.deleteById(id);
        return true;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }


    public Boolean addCourseToStudent(int id , List<Course> courses) {
        try{
            Student student = studentRepository.findById(id).get();
            student.getCourses().addAll(courses);
            studentRepository.save(student);
            return true;
        }catch (Exception e){

            return false;
        }
    }

    @Transactional
    public Boolean updateStudent(int id ,Student NewStudent) {
        try{
            Student student = studentRepository.findById(id).get();
            student.setFullname(NewStudent.getFullname());
            student.setDob(NewStudent.getDob());

            studentRepository.save(student);
            return true;
        }catch (Exception e){

            return false;
        }
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getStudentsLike(String kw) {
        List<Optional<Student>> optionalStudents = studentRepository.getAllByFullnameLike(kw);

        // Convert the list of Optionals to a list of non-empty Students
        List<Student> students = optionalStudents.stream()
                .filter(Optional::isPresent) // Filter out empty optionals
                .map(Optional::get) // Extract the Students from non-empty optionals
                .collect(Collectors.toList()); // Collect into a new list

        return students;
    }


}
