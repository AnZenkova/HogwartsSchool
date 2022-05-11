package ru.hogwarts.school.serviceImpl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    private Map<Long, Faculty> facultyMap = new HashMap<>();
    private Long lastId = 0l;

    private void counterId() {
        lastId++;
    }

    public Faculty createFaculty(Faculty faculty) {
        counterId();
        faculty.setId(lastId);
        facultyMap.put(lastId, faculty);
        return faculty;
    }

    public Faculty findFaculty(Long id) {
        return facultyMap.get(id);
    }

    public Faculty editFaculty(Faculty faculty) {
        if (facultyMap.containsKey(faculty.getId())) {
            facultyMap.put(faculty.getId(), faculty);
            return faculty;
        }
        throw new RuntimeException("Данный факультет отсутсвует");
    }

    public Faculty deleteFaculty(Long id) {
        return facultyMap.remove(id);
    }

    public List<Faculty> getAll() {
        List<Faculty> allFaculty = new ArrayList<>(facultyMap.values());
        return allFaculty;
    }

    public Set<Faculty> filterFaculty(String color) {
        Set<Faculty> filter = facultyMap.values().stream()
                .filter(s -> s.getColor().equals(color))
                .collect(Collectors.toSet());
        return filter;
    }
}
