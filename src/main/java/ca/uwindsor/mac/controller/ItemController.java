package ca.uwindsor.mac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.uwindsor.mac.model.Inventory;
import ca.uwindsor.mac.model.Parent;
import ca.uwindsor.mac.service.InventoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private InventoryService invService;
	
	 @PostMapping("/saveInventory")
	   public ResponseEntity<?> save(@RequestBody Inventory inv) {
	      long id = invService.save(inv);
	      return ResponseEntity.ok().body("New Inventory has been saved with ID:" + id);
	   }
	 
	 @GetMapping("/inventory")
	   public ResponseEntity<List<Inventory>> list() {
	      List<Inventory> inv = invService.list();
	      return ResponseEntity.ok().body(inv);
	   }

	   /*---Update a book by id---*/
	   @PutMapping("/inventory/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Inventory inv) {
		   invService.update(id, inv);
	      return ResponseEntity.ok().body("Parent has been updated successfully.");
	   }


}
