package spm.erp.hr.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import spm.erp.hr.domain.Entities.Employee;
import spm.erp.hr.repositories.EmployeeRepository;

public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;
	}

	public Optional<Employee> getEmployee(String id) { // TODO: Inspect optional
		return employeeRepository.findById(id);
	}

	public void updateEmployee(String id, Employee updatedEmployee) {
		employeeRepository.save(updatedEmployee);
	}

	public void addEmployee(Employee newEmployee) {
		employeeRepository.save(newEmployee);
	}

	public void deactivateEmployee(String id) {
		// TODO
	}
}
