package ca.uwindsor.mac.controller;

import java.util.ArrayList;
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

import ca.uwindsor.mac.model.NewStudent;
import ca.uwindsor.mac.model.Rank;
import ca.uwindsor.mac.model.Rank_Student;
import ca.uwindsor.mac.model.Student;
import ca.uwindsor.mac.model.Student_Parent;
import ca.uwindsor.mac.service.ParentService;
import ca.uwindsor.mac.service.RankService;
import ca.uwindsor.mac.service.RankStudentService;
import ca.uwindsor.mac.service.StudentService;
import ca.uwindsor.mac.service.Student_Parent_Service;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ParentService parentService;
	@Autowired
	private Student_Parent_Service spService;
	@Autowired
	private RankService rankService;
	
	@Autowired
	private RankStudentService rsService;
	
	
	
	 /*---Add new student---*/
	   @PostMapping("/saveNewStudent")
	   public ResponseEntity<?> save(@RequestBody NewStudent newStudent) {
	        
		   studentService.save(newStudent.getStudent());
		   parentService.save(newStudent.getParent());
		   rankService.save(newStudent.getRank());
		   
		   Student_Parent sp=new Student_Parent();
		   sp.setParent(newStudent.getParent());
		   sp.setStudent(newStudent.getStudent());
		   sp.setSp_relation(newStudent.getRelation());
		   spService.save(sp);
		   
		   Rank_Student rs = new Rank_Student();
		   rs.setRank(newStudent.getRank());
		   rs.setStudent(newStudent.getStudent());
		   rsService.save(rs);
	      return ResponseEntity.ok().body("New Student has been saved Successfully");
	   }
	   
	   
	   
	   @GetMapping("/getAllStudents")
	   public ResponseEntity<List<NewStudent>> listAll() {
	      List<NewStudent> students = new ArrayList<NewStudent>();
	      List<Student> st=studentService.list();
	      NewStudent n;
	      Rank r;
	    
	      for(Student s:st) {
	    	  n=new NewStudent();
	    	  r=rsService.getRankByStudent(s);
	    	  n.setStudent(s);
	    	  n.setParent(spService.getParentByStudent(s));
	    	  n.setRank(r);
	    	  n.setRelation("Parent");
	    	  students.add(n);
	      }
	      return ResponseEntity.ok().body(students);
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
	      return ResponseEntity.ok().body("Student has been updated successfully.");
	   }

	   /*---Delete a book by id---*/
	   @DeleteMapping("/student/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   studentService.delete(id);
	      return ResponseEntity.ok().body("Student has been deleted successfully.");
	   }
}
