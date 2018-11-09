package spm.erp.hr.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spm.erp.hr.domain.Entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
