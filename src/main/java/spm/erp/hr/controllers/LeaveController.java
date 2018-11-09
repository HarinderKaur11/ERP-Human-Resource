package spm.erp.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spm.erp.hr.domain.Entities.Leave;
import spm.erp.hr.services.LeaveService;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

	@Autowired
	private LeaveService leaveService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Leave> getAllEmployees() {
//		employeeService.addEmployee(null);
		return leaveService.getAllLeaves();
//		return null;
	}

}
