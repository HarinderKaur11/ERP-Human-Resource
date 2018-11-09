package spm.erp.hr.domain.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	private String name;
	private Integer dob;
	private String address;
	private Boolean status;
	private String role;

//	public Leave getLeaves() {
//		return leaves;
//	}
//
//	public void setLeaves(Leave leaves) {
//		this.leaves = leaves;
//	}

	@JsonManagedReference
	@OneToOne(mappedBy = "employee", cascade = { CascadeType.ALL })
	private Leave leaves;

	@OneToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "supervisor")
	Employee supervisor;

	public Employee() {
		// No argument Constructor
	}

	public Employee(String name, Integer dob, String address, Boolean status, String role, Employee supervisor) {
		super();
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.status = status;
		this.role = role;
		this.supervisor = supervisor;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDob() {
		return dob;
	}

	public void setDob(Integer dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Leave getLeaves() {
		return leaves;
	}

	public void setLeaves(Leave leaves) {
		this.leaves = leaves;
	}

	public Employee getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}

}
