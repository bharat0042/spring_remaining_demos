package com.bharat.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bharat.rest.entity.Student;
import com.bharat.rest.exception.StudentErrorResponse;
import com.bharat.rest.exception.StudentNotFound;

@RestController
@RequestMapping("/api")
public class DemoRestController {
	
	private List<Student> list;
	
	@PostConstruct
	public void loadData() {
		list = new ArrayList<Student>();
		list.add(new Student("Bruce", "Wayne"));
		list.add(new Student("Lex", "Luther"));
		list.add(new Student("Barry", "Allen"));
	}

	@GetMapping("/getStudent")
	public List<Student> getStudent() {
		return list;
	}
	
	@GetMapping("/getStudent/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		if(studentId >= list.size() || studentId < 0) {
			throw new StudentNotFound("Student not found for id - " + studentId);
		}
		return list.get(studentId);
	}
	

}

