package spm.erp.hr.domain.Entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	private String name;
	private Date dob;
	private String address;
	private Boolean status;
	private String role;

	@JsonIgnore
	@JsonManagedReference
	@OneToOne(mappedBy = "employee", cascade = { CascadeType.ALL })
	private Leave leaves;

	@JsonIgnore
	@OneToOne()
	@JoinColumn(name = "supervisor")
	Employee supervisor;

	public Employee() {
		// No argument Constructor
	}

	public Employee(String name, Date dob, String address, Boolean status, String role, Employee supervisor) {
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
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

	@JsonIgnore
	public Leave getLeaves() {
		return leaves;
	}

	@JsonProperty
	public void setLeaves(Leave leaves) {
		this.leaves = leaves;
	}

	@JsonIgnore
	public Employee getSupervisor() {
		return supervisor;
	}

	@JsonProperty
	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
