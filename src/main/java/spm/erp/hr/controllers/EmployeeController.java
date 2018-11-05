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
@RequestMapping("/hr")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@RequestMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable String id) {
		return employeeService.getEmployee(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employees")
	public void addEmployee(@RequestBody Employee newEmployee) {
		employeeService.addEmployee(newEmployee);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/employees/{id}")
	public void updateEmployee(@PathVariable String id, @RequestBody Employee updatedEmployee) {
		employeeService.updateEmployee(id, updatedEmployee);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
	public void deactivateEmployee(@PathVariable String id) {
		employeeService.deactivateEmployee(id);
	}
}
