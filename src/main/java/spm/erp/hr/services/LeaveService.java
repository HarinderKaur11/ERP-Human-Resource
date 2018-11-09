package spm.erp.hr.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spm.erp.hr.domain.Entities.Leave;
import spm.erp.hr.repositories.LeaveRepository;

@Service
public class LeaveService {

	@Autowired
	private LeaveRepository leaveRepository;

	public List<Leave> getAllLeaves() {
		List<Leave> leaves = new ArrayList<>();
		leaveRepository.findAll().forEach(leaves::add);
		return leaves;

	}

}
