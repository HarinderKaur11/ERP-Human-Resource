package spm.erp.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spm.erp.hr.domain.Entities.Employee;
import spm.erp.hr.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@RequestMapping("/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		return employeeService.getEmployee(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee updatedEmployee) {
		return employeeService.updateEmployee(id, updatedEmployee);
	}

}
