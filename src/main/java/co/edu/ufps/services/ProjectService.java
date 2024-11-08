package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Project;

import co.edu.ufps.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	
	public List<Project> list() {
		return projectRepository.findAll();
	}
	
	public Project update(Integer id,Project projectDetails) {
		Optional<Project> SelecionOpt = projectRepository.findById(id);

		if (!SelecionOpt.isPresent()) {
			return null;
		}

		Project project = SelecionOpt.get();
		
		project.setName(projectDetails.getName());
		project.setDescripcion(projectDetails.getDescripcion());
		project.setStart_date(projectDetails.getStart_date());
		project.setEnd_date(projectDetails.getEnd_date());
		

		return projectRepository.save(project);
	}
}