package StudentCourses.controller;

import StudentCourses.entity.Course;
import StudentCourses.entity.Student;
import StudentCourses.repository.ICourseRepository;
import StudentCourses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/students")
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ICourseRepository courseRepository;

    private List<Course> coursesList = new ArrayList<>();

    public StudentController(StudentService studentService, ICourseRepository courseRepository) {
        this.studentService = studentService;
        this.courseRepository = courseRepository;

        this.coursesList = this.courseRepository.findAllSortByName();
    }


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/new")
    public String createStudentForm(Model model) {

        // este objeto Student almacenara los valores 
        Student student = new Student();

        model.addAttribute("student", student);
        model.addAttribute("coursesList", coursesList);

        return "create_student";
    }

    @PostMapping
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        Student st = studentService.getStudentById(id);

        model.addAttribute("student", st);
        model.addAttribute("coursesList", coursesList);

        return "edit_student";
    }

    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model) {
        //sacar el esudiante de la b.d. por el id
        Student existentStudent = studentService.getStudentById(id);
        // cargarlo
        existentStudent.setId(id);
        existentStudent.setFirstName(student.getFirstName());
        existentStudent.setLastName(student.getLastName());
        existentStudent.setEmail(student.getEmail());
        existentStudent.setCourses(student.getCourses());

        // guardar el estudiante actualizado
        studentService.updateStudent(existentStudent);

        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
