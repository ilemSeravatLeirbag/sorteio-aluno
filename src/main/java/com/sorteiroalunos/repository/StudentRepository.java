package com.sorteiroalunos.repository;

import com.sorteiroalunos.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
