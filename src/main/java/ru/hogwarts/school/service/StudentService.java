package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.List;
import java.util.Set;

public interface StudentService {

    Student createStudent(Student student);
    Student findStudent(Long id);
    Student editStudent(Student student);
    Student deleteStudent(Long id);
    Set<Student> filterStudent(int age);
    List<Student> getAll();

}
