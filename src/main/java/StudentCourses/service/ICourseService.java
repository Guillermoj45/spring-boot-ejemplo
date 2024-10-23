
package StudentCourses.service;

import java.util.List;

import StudentCourses.entity.Course;


public interface ICourseService {
    
    List<Course> getAllCourses();
    
    List<Course> getCourseByName(String name);
    
    List<Course> getCourseByFee(double fee);
    
    Course saveCourse(Course course);
    
    Course getCourseById(Long id);
    
    Course updateCourse(Course course);
    
    void deleteCourseById(Long id);
    
}
