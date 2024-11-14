package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.ProjectAssignment;
import co.edu.ufps.repositories.ProjectAssignmentRepository;


@Service
public class ProjectAssigmentService{

	@Autowired
	ProjectAssignmentRepository projectAssigmentRepository;
	
	
	public List<ProjectAssignment> list() {
		return projectAssigmentRepository.findAll();
	}
	
	public ProjectAssignment crearProjectAssigment(ProjectAssignment p) {
		return projectAssigmentRepository.save(p);
	}
	
	public ProjectAssignment getListar1(Integer id) {
		Optional<ProjectAssignment> projectAssigmentOpt =  projectAssigmentRepository.findById(id);
		
		if (projectAssigmentOpt.isPresent()) {
			return projectAssigmentOpt.get();
		}
		
		return null;
	}
}