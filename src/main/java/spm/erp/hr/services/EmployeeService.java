package spm.erp.hr.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spm.erp.hr.domain.Entities.Employee;
import spm.erp.hr.exceptions.ResourceNotFoundException;
import spm.erp.hr.repositories.EmployeeRepository;

/**
 * The Class EmployeeService.
 */
@Service
public class EmployeeService {

	/** The employee repository. */
	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;
	}

	/**
	 * Gets the employee.
	 *
	 * @param id the id
	 * @return the employee
	 */
	public Employee getEmployee(Integer id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No employee exist with ID:" + id));
	}

	/**
	 * Update employee.
	 *
	 * @param id              the id
	 * @param updatedEmployee the updated employee
	 * @return the employee
	 */
	public Employee updateEmployee(Integer id, Employee updatedEmployee) {
		Employee oldEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No employee exist with ID:" + id));
		return employeeRepository.save(updatedEmployee);
	}

	/**
	 * Adds the employee.
	 *
	 * @param employee the employee
	 * @return the employee
	 */
	public Employee addEmployee(Employee employee) {
		if (Objects.nonNull(employee.getSupervisor()) && Objects.nonNull(employee.getSupervisor().getEmpId())) {
			getEmployee(employee.getSupervisor().getEmpId());
		}
		employee.getLeaves().setEmployee(employee);
		return employeeRepository.save(employee);
	}

	/**
	 * Gets the subordinates.
	 *
	 * @param id the id
	 * @return the subordinates
	 */
	public List<Employee> getSubordinates(Integer id) {
		return employeeRepository.getEmployeeSubordinates(getEmployee(id));
	}

	/**
	 * Gets the supervisor.
	 *
	 * @param id the id
	 * @return the supervisor
	 */
	public Employee getSupervisor(Integer id) {
		return Optional.ofNullable(getEmployee(id).getSupervisor())
				.orElseThrow(() -> new ResourceNotFoundException("No supervisor exist for employee with ID:" + id));
	}

}
