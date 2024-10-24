package StudentCourses.service;

import StudentCourses.entity.Teacher;
import StudentCourses.repository.ITeacherRepository;

import java.util.List;

public class TeacherService implements ITeacherService {
    private ITeacherRepository teacherRepository;

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    @Override
    public Teacher getTeacherByName(String name) {
        return teacherRepository.findByName(name);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}
