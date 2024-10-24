package StudentCourses.controller;


import StudentCourses.entity.Teacher;
import StudentCourses.repository.ITeacherRepository;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@RequestMapping("/teachers")
@RestController
public class TeacherController {

    ITeacherRepository teacherRepository;

    @GetMapping("/")
    public List<Teacher> home() {
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(Integer id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @PutMapping("/")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @DeleteMapping("/{id}")
    public String deleteTeacherById(Integer id) {
        teacherRepository.deleteById(id);
        return "redirect:/teachers/";
    }
}
