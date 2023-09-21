package me.drisssatkou.demo.Repositories;

import me.drisssatkou.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

//make a query to get all students by fullname
@Query("SELECT s FROM Student s WHERE s.fullname LIKE %?1%")
public List<Optional<Student>> getAllByFullnameLike(@Param("fullname") String fullname);
}
