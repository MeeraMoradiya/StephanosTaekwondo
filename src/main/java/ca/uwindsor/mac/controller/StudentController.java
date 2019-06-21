package ca.uwindsor.mac.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.text.SimpleDateFormat;

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

import com.mchange.v2.util.CollectionUtils;

import ca.uwindsor.mac.model.Attendance;
import ca.uwindsor.mac.model.Class;
import ca.uwindsor.mac.model.Fees;
import ca.uwindsor.mac.model.FeesWrapper;
import ca.uwindsor.mac.model.Membership;
import ca.uwindsor.mac.model.NewStudent;
import ca.uwindsor.mac.model.Parent;
import ca.uwindsor.mac.model.Rank;
import ca.uwindsor.mac.model.Rank_Student;
import ca.uwindsor.mac.model.Student;
import ca.uwindsor.mac.model.Student_Parent;
import ca.uwindsor.mac.model.ViewReportInput;
import ca.uwindsor.mac.model.ViewStudentModel;
import ca.uwindsor.mac.service.AttandenceService;
import ca.uwindsor.mac.service.ClassRegistrationService;
import ca.uwindsor.mac.service.ClassService;
import ca.uwindsor.mac.service.FeesService;
import ca.uwindsor.mac.service.MembershipService;
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
	
	@Autowired
	private MembershipService memService;
	
	@Autowired
	private AttandenceService atService;
	
	@Autowired
	private FeesService feesService;
	
	@Autowired
	private ClassRegistrationService clsService;
	
	

	/*---Add new student---*/
	@PostMapping("/saveNewStudent")
	public ResponseEntity<?> save(@RequestBody NewStudent newStudent) {

		studentService.save(newStudent.getStudent());
		parentService.save(newStudent.getParent());
		rankService.save(newStudent.getRank());

		Student_Parent sp = new Student_Parent();
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
		List<Student> st = studentService.list();
		NewStudent n;
		Rank r;

		for (Student s : st) {
			
			if(s.getStudent_status().equalsIgnoreCase("ACTIVE")) {
			n = new NewStudent();
			r = rsService.getRankByStudent(s);
			n.setStudent(s);
			n.setParent(spService.getParentByStudent(s));
			n.setRank(r);
			n.setRelation("Parent");
			
			students.add(n);
			}
		}
		return ResponseEntity.ok().body(students);
	}

	@GetMapping("/viewStudent/{id}")
	public ResponseEntity<ViewStudentModel> get(@PathVariable("id") long id) {
		ViewStudentModel vw = new ViewStudentModel();
		Student student = studentService.get(id);
		Rank r = rsService.getRankByStudent(student);
		
		vw.setParent(spService.getParentByStudent(student));
		vw.setStudent(student);
		vw.setMem(memService.getMembershipByStudentId(id));
		vw.setRank(r);
		vw.setFees(feesService.getFeesByStudentId(id));
		vw.setAttend(atService.getAttendanceByStudent(id));
		vw.setRankDate(rsService.getRankDateByStudentId(id));
		vw.setCls(clsService.getClassByStudentId(id));
		return ResponseEntity.ok().body(vw);
	}
	
	@GetMapping("/testObject")
	public ResponseEntity<FeesWrapper> testObject() {
		FeesWrapper v= new FeesWrapper();
		
		
		return ResponseEntity.ok().body(v);
	}
	
	@PostMapping("/saveFees")
	   public ResponseEntity<?> save(@RequestBody FeesWrapper fw) {
		Fees fees=new Fees();
		fees.setStudent(studentService.get(fw.getSid()));
		fees.setMembership(memService.get(fw.getmId()));
		fees.setF_date(new Date());
		fees.setF_amount(fw.getCost());
		
	      long id = feesService.save(fees);
	      return ResponseEntity.ok().body("Fees has been saved ");
	   }
	
	 @GetMapping("/fees")
	   public ResponseEntity<List<Fees>> listFees() {
	      List<Fees> students = feesService.list();
	      return ResponseEntity.ok().body(students);
	   }
	
	
	@PostMapping("/viewReport")
	public ResponseEntity<List<ViewStudentModel>> viewReport(@RequestBody ViewReportInput input) {
		List<ViewStudentModel> vwList=new ArrayList<ViewStudentModel>();
		ArrayList<Long> listDOJ =new ArrayList<Long>();
		ArrayList<Long> listStatus =new ArrayList<Long>();
		ArrayList<Long> listCity =new ArrayList<Long>();
		List<Long> listIds=new ArrayList<Long>();
		
		
		if(input.getReportFrom() != null && input.getReportTo() !=null) {
			 listDOJ = studentService.getStudentListByDOJ(input.getReportFrom(), input.getReportTo());
		}
		
		if(input.getStatus() != null) {
			listStatus=studentService.getStudentListByStatus(input.getStatus());
		}
		
		if(input.getCity() != null) {
			listCity=studentService.getStudentListByCity(input.getCity());
		}
		
		listIds=listDOJ.stream()
	    .filter(listStatus::contains)
	    .collect(Collectors
	    .toList());
		for(long l:listIds) {
			ResponseEntity<ViewStudentModel> v=	get(l);
			vwList.add(v.getBody());
		}
		
		return ResponseEntity.ok().body(vwList);
	}

	

	/*
	 * ---Get a student by id---
	 * 
	 * @GetMapping("/student/{id}") public ResponseEntity<Student>
	 * get(@PathVariable("id") long id) {
	 * 
	 * Student student = studentService.get(id); return
	 * ResponseEntity.ok().body(student); }
	 */

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
