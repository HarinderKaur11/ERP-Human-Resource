package spm.erp.hr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spm.erp.hr.domain.Entities.Leave;

/**
 * The Interface LeaveRepository.
 */
@Repository
public interface LeaveRepository extends CrudRepository<Leave, Integer> {

	/**
	 * Employees over used leaves.
	 *
	 * @return the list
	 */
	@Query("SELECT l FROM Leave l WHERE l.leavesTaken > l.leavesAllowed")
	public List<Leave> employeesOverUsedLeaves();

}
