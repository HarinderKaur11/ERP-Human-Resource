package spm.erp.hr.services;

import java.util.ArrayList;
import java.util.List;

import spm.erp.hr.domain.Entities.Employee;

public class EmployeeService {

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		// TODO
		// repository operation to fetch employees
		return employees;
	}

	public Employee getEmployee(String id) {
		return null;
	}

	public void updateEmployee(String id, Employee updatedEmployee) {
		// TODO
	}

	public void addEmployee(Employee newEmployee) {
		// TODO
	}

	public void deactivateEmployee(String id) {
		// TODO
	}
}
