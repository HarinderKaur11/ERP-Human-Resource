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

/**
 * The Class EmployeeController.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	/** The employee service. */
	@Autowired
	private EmployeeService employeeService;

	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	/**
	 * Gets the employee.
	 *
	 * @param id the id
	 * @return the employee
	 */
	@RequestMapping("/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		return employeeService.getEmployee(id);
	}

	/**
	 * Adds the employee.
	 *
	 * @param employee the employee
	 * @return the employee
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	/**
	 * Update employee.
	 *
	 * @param id              the id
	 * @param updatedEmployee the updated employee
	 * @return the employee
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee updatedEmployee) {
		return employeeService.updateEmployee(id, updatedEmployee);
	}

	/**
	 * Gets the subordinates.
	 *
	 * @param id the id
	 * @return the subordinates
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}/subordinates")
	public List<Employee> getSubordinates(@PathVariable("id") Integer id) {
		return employeeService.getSubordinates(id);
	}

	/**
	 * Gets the supervisor.
	 *
	 * @param id the id
	 * @return the supervisor
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}/supervisor")
	public Employee getSupervisor(@PathVariable("id") Integer id) {
		return employeeService.getSupervisor(id);
	}

}
