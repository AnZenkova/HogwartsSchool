package ru.hogwarts.school.serviceImpl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private Map<Long, Student> studentMap = new HashMap<>();
    private Long lastId = 0l;

    private void counterId() {
        lastId++;
    }

    public Student createStudent(Student student) {
        counterId();
        studentMap.put(lastId, student);
        return student;
    }

    public Student findStudent(Long id) {
        return studentMap.get(id);
    }

    public Student editStudent(Student student) {
        if (studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
            return student;
        }
        throw new RuntimeException("Данный студент отсутсвует");
    }

    public Student deleteStudent(Long id) {
        return studentMap.remove(id);
    }

    public List<Student> getAll() {
        List<Student> allStudent = new ArrayList<>(studentMap.values());
        return allStudent;
    }

    public Set<Student> filterStudent(int age) {
        Set<Student> filter = studentMap.values().stream()
                .filter(s -> s.getAge() == age)
                .collect(Collectors.toSet());
        return filter;
    }
}
