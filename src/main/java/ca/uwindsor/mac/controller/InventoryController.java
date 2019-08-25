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

import ca.uwindsor.mac.model.Inventory;
import ca.uwindsor.mac.service.InventoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class InventoryController {
	
	@Autowired
	private InventoryService InventoryService;
	
	 @PostMapping("/saveInventory")
	   public ResponseEntity<?> save(@RequestBody Inventory Inventory) {
	      long id = InventoryService.save(Inventory);
	      return ResponseEntity.ok().body("New Inventory has been saved with ID:" + id);
	   }

	   /*---Get a student by id---*/
	   @GetMapping("/Inventory/{id}")
	   public ResponseEntity<Inventory> get(@PathVariable("id") long id) {
	      Inventory Inventory = InventoryService.get(id);
	      return ResponseEntity.ok().body(Inventory);
	   }

	   /*---get all books---*/
	   @GetMapping("/Inventory")
	   public ResponseEntity<List<Inventory>> list() {
	      List<Inventory> students = InventoryService.list();
	      return ResponseEntity.ok().body(students);
	   }

	   /*---Update a book by id---*/
	   @PutMapping("/Inventory/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Inventory student) {
		   InventoryService.update(id, student);
	      return ResponseEntity.ok().body("Inventory has been updated successfully.");
	   }

	   /*---Delete a book by id---*/
	   @DeleteMapping("/Inventory/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   InventoryService.delete(id);
	      return ResponseEntity.ok().body("Inventory has been deleted successfully.");
	   }

}
