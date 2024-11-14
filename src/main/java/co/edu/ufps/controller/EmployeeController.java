package co.edu.ufps.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.entities.Employee;

import co.edu.ufps.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> list() {
		return ResponseEntity.ok(employeeService.list());
	}
	
	
	@PostMapping("/crear")
	public ResponseEntity<Employee> postEmployee(@RequestBody Employee p) {
		return ResponseEntity.ok(employeeService.crearEmployee(p));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getListar1(@PathVariable Integer id) {
		return ResponseEntity.ok(employeeService.getListar1(id));
	}
}
