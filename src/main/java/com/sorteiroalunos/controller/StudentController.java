package com.sorteiroalunos.controller;

import com.sorteiroalunos.dto.CreateStudentsDTO;
import com.sorteiroalunos.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<String> getStudents(){
        return service.generateStudents();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody CreateStudentsDTO obj) {
        service.create(obj.getNames());
    }
}
