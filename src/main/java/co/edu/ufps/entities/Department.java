package co.edu.ufps.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="chief_id")
	private Employee jefe;
	
	
	@ManyToMany(mappedBy = "departments")
	@JsonIgnore
	List<Employee> employees;
	
	@OneToMany(mappedBy="departmentss",cascade= CascadeType.ALL)
	@JsonIgnore
	private List<Employee> Employee;
	
	public void addEmployee(Employee e) {
		this.Employee.add(e);
	}
	
	public void removeEmployee(Employee e) {
		this.Employee.remove(e);
	}
	
	
}
