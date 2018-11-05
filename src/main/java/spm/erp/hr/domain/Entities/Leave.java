package spm.erp.hr.domain.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Leave {

	@Id
	@GeneratedValue
	private Integer leaveId;
//	@OneToOne(mappedBy = "leaves")
//	private Employee emp_id;
	private Integer leavesAllowed;
	private Integer leaversTaken;

	public Integer getLeavesAllowed() {
		return leavesAllowed;
	}

	public void setLeavesAllowed(Integer leavesAllowed) {
		this.leavesAllowed = leavesAllowed;
	}

	public Integer getLeaversTaken() {
		return leaversTaken;
	}

	public void setLeaversTaken(Integer leaversTaken) {
		this.leaversTaken = leaversTaken;
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
