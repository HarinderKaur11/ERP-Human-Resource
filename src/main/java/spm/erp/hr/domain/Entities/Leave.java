package spm.erp.hr.domain.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer leaveId;
	@OneToOne()
	@JoinColumn(name = "employ")
	@JsonBackReference
	private Employee employee;
	private Integer leavesAllowed;
	private Integer leavesTaken;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getLeavesAllowed() {
		return leavesAllowed;
	}

	public void setLeavesAllowed(Integer leavesAllowed) {
		this.leavesAllowed = leavesAllowed;
	}

	public Integer getLeavesTaken() {
		return leavesTaken;
	}

	public void setLeavesTaken(Integer leavesTaken) {
		this.leavesTaken = leavesTaken;
	}

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

//	public Employee getEmp_id() {
//		return emp_id;
//	}
//
//	public void setEmp_id(Employee emp_id) {
//		this.emp_id = emp_id;
//	}

}
