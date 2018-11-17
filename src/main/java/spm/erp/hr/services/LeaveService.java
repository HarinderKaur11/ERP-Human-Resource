package spm.erp.hr.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spm.erp.hr.domain.Entities.Employee;
import spm.erp.hr.domain.Entities.Leave;
import spm.erp.hr.exceptions.ResourceNotFoundException;
import spm.erp.hr.repositories.LeaveRepository;

/**
 * The Class LeaveService.
 */
@Service
public class LeaveService {

	/** The leave repository. */
	@Autowired
	private LeaveRepository leaveRepository;

	/** The employee service. */
	@Autowired
	private EmployeeService employeeService;

	/**
	 * Gets the leave.
	 *
	 * @param id the id
	 * @return the leave
	 */
	public Leave getLeave(Integer id) {
		return leaveRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Leave exist with ID:" + id));
	}

	/**
	 * Increment leaves.
	 *
	 * @param empId       the emp id
	 * @param numOfLeaves the num of leaves
	 * @return the leave
	 */
	public Leave incrementLeaves(Integer empId, Integer numOfLeaves) {
		if (numOfLeaves < 1) {
			throw new IllegalArgumentException("Number of leaves must be greater than zero");
		}
		Employee emp = employeeService.getEmployee(empId);
		Leave leaves = emp.getLeaves();

		leaves.setLeavesTaken(
				Objects.nonNull(leaves.getLeavesTaken()) ? leaves.getLeavesTaken() + numOfLeaves : numOfLeaves);
		return leaveRepository.save(leaves);

	}

	/**
	 * Gets the employees with overused leaves.
	 *
	 * @return the employees with overused leaves
	 */
	public List<Employee> getEmployeesWithOverusedLeaves() {
		return leaveRepository.employeesOverUsedLeaves().stream().map(leave -> leave.getEmployee())
				.collect(Collectors.toList());
	}

	/**
	 * Gets the leave of employee.
	 *
	 * @param empId the emp id
	 * @return the leave of employee
	 */
	public Leave getLeaveOfEmployee(Integer empId) {
		return employeeService.getEmployee(empId).getLeaves();
	}

	/**
	 * Update leaves.
	 *
	 * @param leaveId the leave id
	 * @param leave   the leave
	 * @return the leave
	 */
	public Leave updateLeaves(Integer leaveId, Leave leave) {
		Leave oldLeave = getLeave(leaveId);
		leave.setLeaveId(leaveId);
		leave.setEmployee(oldLeave.getEmployee());
		return leaveRepository.save(leave);
	}

}
