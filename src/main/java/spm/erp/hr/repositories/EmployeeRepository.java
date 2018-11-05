package spm.erp.hr.repositories;

import org.springframework.data.repository.CrudRepository;

import spm.erp.hr.domain.Entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
