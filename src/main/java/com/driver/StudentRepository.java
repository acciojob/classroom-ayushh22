package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String, Student> stuDB;
    HashMap<String, Teacher> teacherDB;
    HashMap<String, List<String>> pairDB;

    public StudentRepository() {
        this.stuDB= new HashMap<>();
        this.teacherDB= new HashMap<>();
        this.pairDB = new HashMap<>();
    }

    public void addStudent(Student student) {
        stuDB.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher) {
        teacherDB.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String stuName, String teacherName) {
        if(stuDB.containsKey(stuName) && teacherDB.containsKey(teacherName)) {
            if(pairDB.containsKey(teacherName))
                pairDB.get(teacherName).add(stuName);
            else {
                List<String> names= new ArrayList<>();
                names.add(stuName);
                pairDB.put(teacherName, names);
            }
        }
    }

    public Student getStudentByName(String name) {
        return stuDB.get(name);
    }

    public Teacher getTeacherByName(String name) {
        return teacherDB.get(name);
    }

    public List<String> getStudentsByTeacherName(String name) {
        return new ArrayList<>(pairDB.keySet());
    }

    public List<String> getAllStudents() {
        return new ArrayList<>(stuDB.keySet());
    }

    public void deleteTeacherByName(String teacherName) {
        if(teacherDB.containsKey(teacherName)) {
            if(pairDB.containsKey(teacherName)) {
                List<String> stu= pairDB.get(teacherName);

                for(String x: stu)
                    stuDB.remove(x);
            }
            pairDB.remove(teacherName);
        }
        teacherDB.remove(teacherName);
    }

    public void deleteAllTeachers() {
        List<String> lst= new ArrayList<>();
        for(String x: pairDB.keySet())
            lst.addAll(pairDB.get(x));

        for(String z: lst)
            stuDB.remove(z);
    }

}
