package ca.uwindsor.mac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ca.uwindsor.mac.model.Student;
import ca.uwindsor.mac.service.StudentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	 /*---Add new student---*/
	   @PostMapping("/saveStudent")
	   public ResponseEntity<?> save(@RequestBody Student student) {
	      long id = studentService.save(student);
	      return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
	   }

	   /*---Get a student by id---*/
	   @GetMapping("/student/{id}")
	   public ResponseEntity<Student> get(@PathVariable("id") long id) {
	      Student student = studentService.get(id);
	      return ResponseEntity.ok().body(student);
	   }

	   /*---get all books---*/
	   @GetMapping("/student")
	   public ResponseEntity<List<Student>> list() {
	      List<Student> students = studentService.list();
	      return ResponseEntity.ok().body(students);
	   }

	   /*---Update a book by id---*/
	   @PutMapping("/student/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Student student) {
		   studentService.update(id, student);
	      return ResponseEntity.ok().body("Book has been updated successfully.");
	   }

	   /*---Delete a book by id---*/
	   @DeleteMapping("/student/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   studentService.delete(id);
	      return ResponseEntity.ok().body("Book has been deleted successfully.");
	   }
}
