package co.edu.ufps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping("/{id}/add_employees/{employeeId}")
	public Department create(@PathVariable Integer id, @PathVariable Integer employeeId) {
		
		Department nuevaDepartment = departmentService.addEmployee(id, employeeId);
		return nuevaDepartment;
	}
	
	@DeleteMapping("/{id}/add_employees/{employeesId}")
	public ResponseEntity<Department> delete(@PathVariable Integer id, @PathVariable Integer employeeId) {
		Department nuevaDepartment = departmentService.removeEmployee(id, employeeId);
		return ResponseEntity.ok(nuevaDepartment);
	}
}
