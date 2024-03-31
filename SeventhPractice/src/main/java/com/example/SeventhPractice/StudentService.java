package com.example.SeventhPractice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private StudentController stController;
	
	public void addStudent(String name, int age) {
		Student s = new Student();
		s.setName(name);
		s.setAge(age);
		stController.save(s);
	}
	
	public List<Student> getAllStudents() {
		return stController.findAll();
	}
	
	public void updateStudent(Long id, String name, int age) {
		Student s = stController.findById(id).orElse(null);
		if(s!=null) {
			s.setName(name);
			s.setAge(age);
			stController.save(s);
		}
	}
	
	public void deleteStudent(Long id) {
		stController.deleteById(id);
	}
}
