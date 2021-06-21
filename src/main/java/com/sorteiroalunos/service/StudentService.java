package com.sorteiroalunos.service;

import com.sorteiroalunos.entity.Student;
import com.sorteiroalunos.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<String> generateStudents() {
        List<String> students = new ArrayList<>();
        ThreadLocalRandom.current().ints(1, 31).distinct().limit(10).forEach(p -> students.add(repository.findById(p).get().getName()));
        return students;
    }

    public void create(List<String> names) {
        names.forEach(n -> repository.save(Student.builder().name(n).build()));
    }
}
