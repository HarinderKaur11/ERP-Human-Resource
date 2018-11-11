package spm.erp.hr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import spm.erp.hr.domain.Entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	@Query("SELECT e FROM Employee e WHERE e.supervisor=:emp")
	List<Employee> getEmployeeSubordinates(@Param("emp") Employee emp);

}
