package spm.erp.hr.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spm.erp.hr.domain.Entities.Employee;
import spm.erp.hr.exceptions.ResourceNotFoundException;
import spm.erp.hr.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;
	}

	public Employee getEmployee(Integer id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No employee exist with ID:" + id));
	}

	public Employee updateEmployee(Integer id, Employee updatedEmployee) {
		employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No employee exist with ID:" + id));
		return employeeRepository.save(updatedEmployee);
	}

	public Employee addEmployee(Employee employee) {
		employee.getLeaves().setEmployee(employee);
		return employeeRepository.save(employee);
	}

}
