package ca.uwindsor.mac.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
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
	
	@Autowired
	private ClassService cService;
	
	

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
	
	@PostMapping("/saveAttendance")
	public ResponseEntity<?> saveAttendance(@RequestBody ArrayList<Long> l) {
		Attendance a;
		for(Long at:l) {
			a=new Attendance();
			a.setA_dateTime(new Date());
			a.setStudent(studentService.get(at));
			//a.setCls(null);
			atService.save(a);
		}
		
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
	
	
	@GetMapping("/searchByName/{name}")
	public ResponseEntity<List<ViewStudentModel>> searchByName(@PathVariable("name") String sName) {
		List<ViewStudentModel> lsView=new ArrayList<ViewStudentModel>();
		ViewStudentModel vw=new ViewStudentModel();
		List<Student> st =studentService.getStudentByName(sName);
		for(Student s:st) {
		ResponseEntity rs=get(s.getStudent_id());
		lsView.add((ViewStudentModel)rs.getBody());
		}
	
		return ResponseEntity.ok().body(lsView);
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
		ArrayList<Long> listStatus1 =new ArrayList<Long>();
		ArrayList<Long> listStatus2 =new ArrayList<Long>();
		ArrayList<Long> listCity =new ArrayList<Long>();
		ArrayList<Long> listRank=new ArrayList<Long>();
		ArrayList<Long> listClass=new ArrayList<Long>();
		
		List<Long> listIds=new ArrayList<Long>();
		List<Student> lstStd=studentService.list();
		for(Student s: lstStd) {
			listIds.add(s.getStudent_id());
		}
		
		
		if(input.getReportFrom() != null && input.getReportTo() !=null) {
			 listDOJ = studentService.getStudentListByDOJ(input.getReportFrom(), input.getReportTo());
		}
		
		if(input.getStatus() != null && !input.getStatus() .isEmpty()) {
			 StringTokenizer st = new StringTokenizer(input.getStatus(),",");  
		     while (st.hasMoreTokens()) {  
		         if(st.nextToken().equalsIgnoreCase("A")) {
		        	 listStatus1=studentService.getStudentListByStatus("ACTIVE");
		         }
		         
		         if(st.nextToken().equalsIgnoreCase("I")) {
		        	 listStatus2=studentService.getStudentListByStatus("INACTIVE");
		         }
		         
		     }  
			
			
		}
		
		if(input.getCity() != null && !input.getCity().isEmpty()) {
			listCity=studentService.getStudentListByCity(input.getCity());
		}
		
		if(input.getBelt() !=null && input.getBelt() != 0) {
			listRank=rsService.getStudentIdByRankId(input.getBelt());
		}
		
		if(input.getClassLevel() != null && !input.getClassLevel().isEmpty()) {
			
			listClass=clsService.getStudentByClassId(1);
		}
		 Set<Long> setIds=(Set<Long>)listIds.stream().collect(Collectors.toSet());
		 Set<Long> setDOJ=(Set<Long>)listDOJ.stream().collect(Collectors.toSet());
		 Set<Long> setStatus=(Set<Long>)listStatus1.stream().collect(Collectors.toSet());
		 Set<Long> setStatus2=(Set<Long>)listStatus2.stream().collect(Collectors.toSet());
		 Set<Long> setCity=(Set<Long>)listCity.stream().collect(Collectors.toSet());
		 Set<Long> setBelt=(Set<Long>)listRank.stream().collect(Collectors.toSet());
		 Set<Long> setClass=(Set<Long>)listClass.stream().collect(Collectors.toSet());
		 if(!setDOJ.isEmpty()) {
			 setIds.retainAll(setDOJ);
		 }
		 if(!setStatus.isEmpty()) {
			 setIds.retainAll(setStatus);
		 }
		 
		 if(!setCity.isEmpty()) {
			 setIds.retainAll(setCity);
		 }
		 
		 if(!setBelt.isEmpty()) {
			 setIds.retainAll(setBelt);
		 }
		 
		 if(!setClass.isEmpty()) {
			 setIds.retainAll(setClass);
		 }
		
		 
		for(Long l:setIds) {
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
	@GetMapping("/totalStudent")
	public ResponseEntity<Integer> list() {
		int size = studentService.list().size();
		return ResponseEntity.ok().body(size);
	}

	/*---Update a book by id---*/
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody NewStudent newStudent) {
		studentService.update(newStudent.getStudent().getStudent_id(),newStudent.getStudent());
		parentService.update(newStudent.getParent().getParent_id(),newStudent.getParent());
		rankService.update(newStudent.getRank().getRankId(),newStudent.getRank());

		Long sp_id = spService.getRelationBySIdAndPid(newStudent.getStudent().getStudent_id(), newStudent.getParent().getParent_id());
		Student_Parent sp=spService.get(sp_id);
		sp.setParent(newStudent.getParent());
		sp.setStudent(newStudent.getStudent());
		sp.setSp_relation(newStudent.getRelation());
		spService.update(sp_id,sp);

		Long rs_id=rsService.getRelationBySidAndRid(newStudent.getStudent().getStudent_id(),newStudent.getRank().getRankId() );
		Rank_Student rs = rsService.get(rs_id);
		rs.setRank(newStudent.getRank());
		rs.setStudent(newStudent.getStudent());
		rsService.update(rs_id,rs);
		
		//studentService.update(id, student);
		return ResponseEntity.ok().body("Student has been updated successfully.");
	}
	
	
	

	/*---Delete a book by id---*/
	@DeleteMapping("/student/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		studentService.delete(id);
		return ResponseEntity.ok().body("Student has been deleted successfully.");
	}
}
