package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    final
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudentService(Student student) {
        studentRepository.addStudent(student);
    }

    public void addTeacherService(Teacher teacher) {
        studentRepository.addTeacher(teacher);
    }

    public void addStudentTeacherPairService(String studentName, String teacherName) {
        studentRepository.addStudentTeacherPair(studentName, teacherName);
    }

    public Student getStudentByNameService(String name) {
        return studentRepository.getStudentByName(name);
    }

    public Teacher getTeacherByNameService(String name) {
        return studentRepository.getTeacherByName(name);
    }

    public List<String> getStudentsByTeacherNameService(String name) {
        return studentRepository.getStudentsByTeacherName(name);
    }

    public List<String> getAllStudentService() {
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherByNameService(String name) {
        studentRepository.deleteTeacherByName(name);
    }

    public void deleteAllTeachersService() {
        studentRepository.deleteAllTeachers();
    }



}
