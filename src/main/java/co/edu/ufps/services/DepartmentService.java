package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Department;
import co.edu.ufps.entities.Employee;

import co.edu.ufps.repositories.DepartmentRepository;
import co.edu.ufps.repositories.EmployeeRepository;


@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public List<Department> list() {
		return departmentRepository.findAll();
	}
	
	public Department getListar1(Integer id) {
		Optional<Department> departmentOpt =  departmentRepository.findById(id);
		
		if (departmentOpt.isPresent()) {
			return departmentOpt.get();
		}
		
		return null;
	}
	
	public Department addEmployee(Integer id, Integer employeeId) {
		
		Optional<Department> departmentOpt =  departmentRepository.findById(id);
		
		if (departmentOpt.isPresent()) {
			Department department = departmentOpt.get();
			Optional<Employee> employeeOpt = employeeRepository.findById(employeeId);
			if (employeeOpt.isPresent()) {
				department.addEmployee(employeeOpt.get());
			}
			
			return departmentRepository.save(department);
		}
		
		return null;
	}
	
	public Department removeEmployee(Integer id, Integer employeeId) {
		
		Optional<Department> departmentOpt = departmentRepository.findById(id);
		
		if (departmentOpt.isPresent()) {
			Department department = departmentOpt.get();
			Optional<Employee> employeeOpt = employeeRepository.findById(employeeId);
			if (employeeOpt.isPresent()) {
				department.removeEmployee(employeeOpt.get());
			}
			return departmentRepository.save(department);
		}
		return null;
	}

}