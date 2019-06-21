package ca.uwindsor.mac.controller;

import java.util.List;

import javax.crypto.spec.IvParameterSpec;

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

import ca.uwindsor.mac.model.Inventory;
import ca.uwindsor.mac.model.Order;
import ca.uwindsor.mac.service.InventoryService;
import ca.uwindsor.mac.service.OrderService;
import ca.uwindsor.mac.service.StudentService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@Autowired
	private InventoryService invService;
	
	@Autowired
	private StudentService studentService;
	
	 @PostMapping("/saveOrder")
	   public ResponseEntity<?> save(@RequestBody Order order) {
	      
		 	Inventory item=invService.get(order.getInv().getInventory_Id());
		 	
		 	order.setStudent(studentService.get(order.getStudent().getStudent_id()));
		 	order.setInv(invService.get(order.getInv().getInventory_Id()));
	
		 	item.setStock( invService.get(order.getInv().getInventory_Id()).getStock() - order.getQty());	 	
		 	invService.update(invService.get(order.getInv().getInventory_Id()).getInventory_Id(), item);   
	      
		 	long id = orderService.save(order);
	      
		 	return ResponseEntity.ok().body("New Order has been saved with ID:" + id);	      
	   }

	   /*---Get a student by id---*/
	   @GetMapping("/Order/{id}")
	   public ResponseEntity<Order> get(@PathVariable("id") long id) {
	      Order Order = orderService.get(id);
	      return ResponseEntity.ok().body(Order);
	   }

	   /*---get all books---*/
	   @GetMapping("/Order")
	   public ResponseEntity<List<Order>> list() {
	      List<Order> students = orderService.list();
	      return ResponseEntity.ok().body(students);
	   }

	   /*---Update a book by id---*/
	   @PutMapping("/Order/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Order student) {
		   orderService.update(id, student);
	      return ResponseEntity.ok().body("Order has been updated successfully.");
	   }

	   /*---Delete a book by id---*/
	   @DeleteMapping("/Order/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   orderService.delete(id);
	      return ResponseEntity.ok().body("Order has been deleted successfully.");
	   }
}
