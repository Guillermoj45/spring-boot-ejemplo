package StudentCourses.repository;

import StudentCourses.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Long> {

    @Query("FROM Student s WHERE s.firstName LIKE :name OR s.lastName LIKE :name")
    public List<Student> findByNameContaining(@Param("name") String name);

}
