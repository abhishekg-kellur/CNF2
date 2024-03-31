package com.example.SeventhPractice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentController extends JpaRepository<Student, Long>{

}
