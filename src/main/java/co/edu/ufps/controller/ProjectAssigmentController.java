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

import co.edu.ufps.entities.ProjectAssignment;
import co.edu.ufps.services.ProjectAssigmentService;

@RestController
@RequestMapping("/projectAssigment")
public class ProjectAssigmentController {

	@Autowired
	ProjectAssigmentService projectAssigmentService;
	
	@GetMapping
	public ResponseEntity<List<ProjectAssignment>> list() {
		return ResponseEntity.ok(projectAssigmentService.list());
	}
	
	
	@PostMapping("/crear")
	public ResponseEntity<ProjectAssignment> postProjectAssigment(@RequestBody ProjectAssignment p) {
		return ResponseEntity.ok(projectAssigmentService.crearProjectAssigment(p));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProjectAssignment> getListar1(@PathVariable Integer id) {
		return ResponseEntity.ok(projectAssigmentService.getListar1(id));
	}
}
