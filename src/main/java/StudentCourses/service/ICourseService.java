package StudentCourses.service;

import StudentCourses.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICourseService {

    List<Course> getAllCourses();

    List<Course> getCourseByName(String name);

    List<Course> getCourseByFee(double fee);

    Course saveCourse(Course course);

    Course getCourseById(Long id);

    Course updateCourse(Course course);

    void deleteCourseById(Long id);

}
