package spm.erp.hr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import spm.erp.hr.domain.Entities.Employee;

/**
 * The Interface EmployeeRepository.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	/**
	 * Gets the employee subordinates.
	 *
	 * @param emp the emp
	 * @return the employee subordinates
	 */
	@Query("SELECT e FROM Employee e WHERE e.supervisor=:emp")
	List<Employee> getEmployeeSubordinates(@Param("emp") Employee emp);

}
