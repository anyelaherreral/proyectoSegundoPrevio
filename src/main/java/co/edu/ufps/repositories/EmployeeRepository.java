package co.edu.ufps.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.entities.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
}
