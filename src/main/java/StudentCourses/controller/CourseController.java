package StudentCourses.controller;

import java.util.ArrayList;
import java.util.List;

import StudentCourses.repository.ICourseRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import StudentCourses.entity.Course;

@Getter
@Setter

@RequestMapping("/courses")
@RestController
@NoArgsConstructor
public class CourseController {

    ICourseRepository courseRepository;

    private List<Course> coursesList = new ArrayList<>();


    @GetMapping("/")
    public List<Course> home() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Course saveCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @PutMapping("/")
    public Course updateCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @DeleteMapping("/{id}")
    public String deleteCourseById(@PathVariable Long id) {
        courseRepository.deleteById(id);
        return "redirect:/courses/";
    }

}
