package co.edu.ufps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.entities.Department;
import co.edu.ufps.entities.Employee;
import co.edu.ufps.entities.Project;

import co.edu.ufps.services.DepartmentService;
import co.edu.ufps.services.EmployeeService;
import co.edu.ufps.services.ProjectService;

@RestController
@RequestMapping("/poject")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@GetMapping
	public ResponseEntity<List<Project>> list() {
		return ResponseEntity.ok(projectService.list());
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Project> update(@PathVariable Integer id, @RequestBody Project updatedSeleccion) {
        return ResponseEntity.ok(projectService.update(id, updatedSeleccion));
    }
}
