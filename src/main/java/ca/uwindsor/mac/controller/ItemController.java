package ca.uwindsor.mac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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

}
