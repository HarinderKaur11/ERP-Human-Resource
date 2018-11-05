package spm.erp.hr.domain.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
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

//	@OneToOne
//	private Leave leaves;

//	Employee supervisor;

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
		// this.supervisor = supervisor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

//	public Employee getSupervisor() {
//		return supervisor;
//	}
//
//	public void setSupervisor(Employee supervisor) {
//		this.supervisor = supervisor;
//	}

}
