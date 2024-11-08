package co.edu.ufps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.entities.Department;
import co.edu.ufps.entities.Department;
import co.edu.ufps.services.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@GetMapping
	public ResponseEntity<List<Department>> list() {
		return ResponseEntity.ok(departmentService.list());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Department> getListar1(@PathVariable Integer id) {
		
		return ResponseEntity.ok(departmentService.getListar1(id));
	}
}
