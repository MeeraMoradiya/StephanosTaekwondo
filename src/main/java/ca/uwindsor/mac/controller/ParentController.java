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

import ca.uwindsor.mac.model.Parent;
import ca.uwindsor.mac.model.Parent;
import ca.uwindsor.mac.service.ParentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ParentController {
	
	@Autowired
	private ParentService parentService;
	
	 @PostMapping("/saveParent")
	   public ResponseEntity<?> save(@RequestBody Parent parent) {
	      long id = parentService.save(parent);
	      return ResponseEntity.ok().body("New Parent has been saved with ID:" + id);
	   }

	   /*---Get a student by id---*/
	   @GetMapping("/parent/{id}")
	   public ResponseEntity<Parent> get(@PathVariable("id") long id) {
	      Parent parent = parentService.get(id);
	      return ResponseEntity.ok().body(parent);
	   }

	   /*---get all books---*/
	   @GetMapping("/parent")
	   public ResponseEntity<List<Parent>> list() {
	      List<Parent> students = parentService.list();
	      return ResponseEntity.ok().body(students);
	   }

	   /*---Update a book by id---*/
	   @PutMapping("/parent/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Parent student) {
		   parentService.update(id, student);
	      return ResponseEntity.ok().body("Parent has been updated successfully.");
	   }

	   /*---Delete a book by id---*/
	   @DeleteMapping("/parent/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   parentService.delete(id);
	      return ResponseEntity.ok().body("Parent has been deleted successfully.");
	   }

}
