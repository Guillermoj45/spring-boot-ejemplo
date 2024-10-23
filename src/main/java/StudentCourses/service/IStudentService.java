package StudentCourses.service;

import java.util.List;

import StudentCourses.entity.Student;

public interface IStudentService {
    
    List<Student> getAllStudents();
    
    List<Student> getStudentByName(String name);
    
    Student saveStudent(Student student);
    
    Student getStudentById(Long id);
    
    Student updateStudent(Student student);
    
    void deleteStudentById(Long id);

}
