package co.edu.ufps.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="position")
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="salary")
	private Double salary;
	
	@OneToMany(mappedBy="position",cascade= CascadeType.ALL)
	@JsonIgnore
	private List<Employee> employees;
	
	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}
	
	public void removeEmployee(Employee employee) {
		this.employees.remove(employee);
	}
}
