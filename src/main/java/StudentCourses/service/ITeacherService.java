package StudentCourses.service;

import StudentCourses.entity.Teacher;

import java.util.List;

public interface ITeacherService {
    public void addTeacher(Teacher teacher);
    public void updateTeacher(Teacher teacher);
    public void deleteTeacher(Teacher teacher);
    public Teacher getTeacherByName(String name);
    public List<Teacher> getAllTeachers();
}
