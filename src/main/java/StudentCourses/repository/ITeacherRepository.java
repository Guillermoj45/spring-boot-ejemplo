package StudentCourses.repository;

import StudentCourses.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query("FROM Teacher t WHERE t.name LIKE :name")
    public Teacher findByName(String name);
}
