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

@RestController
@RequestMapping("/employees/leaves")
public class LeaveController {

	@Autowired
	private LeaveService leaveService;

	@RequestMapping(value = "/increment-leave", method = RequestMethod.PUT)
	public Leave updateLeavesOfEmployee(@RequestParam(name = "empid") Integer empId,
			@RequestParam(name = "numofleaves") Integer numOfLeaves) {
		return leaveService.incrementLeaves(empId, numOfLeaves);

	}

	@RequestMapping(value = "/update-leave/{leaveid}", method = RequestMethod.PUT)
	public Leave updateLeavesOfEmployee(@PathVariable(name = "leaveid") Integer leaveId, @RequestBody Leave leave) {
		return leaveService.updateLeaves(leaveId, leave);

	}

	@RequestMapping(value = "/employee-overused-leaves", method = RequestMethod.GET)
	public List<Employee> updateLeavesOfEmployee() {
		return leaveService.getEmployeesWithOverusedLeaves();

	}

	@RequestMapping(method = RequestMethod.GET)
	public Leave getLeavesOfEmployee(@RequestParam("empid") Integer empId) {
		return leaveService.getLeaveOfEmployee(empId);

	}

}
