package com.codegym.service.impl;

import com.codegym.model.Student;
import com.codegym.service.StudentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl  implements StudentService {
    private static List<Student> students;

    static {

        students = new ArrayList<>();
        students.add( new Student(1, "nhat", "h2",15,"vietnam"));
        students.add( new Student(2, "linh", "h3",16,"mi"));
        students.add( new Student(3, "long", "h3",17,"lao"));
        students.add( new Student(4, "trung", "h4",18,"campuchia"));
        students.add( new Student(5, "ron", "h5",13,"xingapo"));
    }


    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public Student findById(int id) {
        for (Student student:students) {
            if(student.getId()==id){
                return student;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Student student) {
        Student studentEdit = findById(id);
        studentEdit.setName(student.getName());
        studentEdit.setAge(student.getAge());
        studentEdit.setAddress(student.getAddress());
        studentEdit.setMasv(student.getMasv());
    }

    @Override
    public void remove(int id) {
        students.remove(id);
    }
}
