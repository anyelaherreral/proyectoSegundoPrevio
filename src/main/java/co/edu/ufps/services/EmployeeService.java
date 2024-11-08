package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Employee;

import co.edu.ufps.repositories.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public List<Employee> list() {
		return employeeRepository.findAll();
	}
	
	public Employee crearEmployee(Employee p) {
		return employeeRepository.save(p);
	}
	
	
}