package ru.hogwarts.school.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    private FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createStudent(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("{id}")
    public ResponseEntity getStudent(@PathVariable Long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping
    public ResponseEntity editStudent(@RequestBody Faculty faculty) {
        Faculty foundFaculty = facultyService.editFaculty(faculty);
        return ResponseEntity.ok(foundFaculty);
    }

    @DeleteMapping("{id}")
    public Faculty deleteStudent(@PathVariable Long id) {
        return facultyService.deleteFaculty(id);
    }

    @GetMapping
    public ResponseEntity filterFaculty(@RequestParam String color) {
        if (color == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(facultyService.filterFaculty(color));
    }
}
