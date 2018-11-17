package spm.erp.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spm.erp.hr.domain.Entities.Employee;
import spm.erp.hr.domain.Entities.Leave;
import spm.erp.hr.services.LeaveService;

/**
 * The Class LeaveController.
 */
@RestController
@RequestMapping("/employees/leaves")
public class LeaveController {

	/** The leave service. */
	@Autowired
	private LeaveService leaveService;

	/**
	 * Update leaves of employee.
	 *
	 * @param empId       the employee id
	 * @param numOfLeaves the number of leaves
	 * @return the leave
	 */
	@RequestMapping(value = "/increment-leave", method = RequestMethod.PUT)
	public Leave updateLeavesOfEmployee(@RequestParam(name = "empid") Integer empId,
			@RequestParam(name = "numofleaves") Integer numOfLeaves) {
		return leaveService.incrementLeaves(empId, numOfLeaves);

	}

	/**
	 * Update leaves of employee.
	 *
	 * @param leaveId the leave id
	 * @param leave   the leave
	 * @return the leave
	 */
	@RequestMapping(value = "/update-leave/{leaveid}", method = RequestMethod.PUT)
	public Leave updateLeavesOfEmployee(@PathVariable(name = "leaveid") Integer leaveId, @RequestBody Leave leave) {
		return leaveService.updateLeaves(leaveId, leave);

	}

	/**
	 * Update leaves of employee.
	 *
	 * @return the list
	 */
	@RequestMapping(value = "/employee-overused-leaves", method = RequestMethod.GET)
	public List<Employee> updateLeavesOfEmployee() {
		return leaveService.getEmployeesWithOverusedLeaves();

	}

	/**
	 * Gets the leaves of employee.
	 *
	 * @param empId the emp id
	 * @return the leaves of employee
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Leave getLeavesOfEmployee(@RequestParam("empid") Integer empId) {
		return leaveService.getLeaveOfEmployee(empId);

	}

}
