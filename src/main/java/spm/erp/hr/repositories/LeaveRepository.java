package spm.erp.hr.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spm.erp.hr.domain.Entities.Leave;

@Repository
public interface LeaveRepository extends CrudRepository<Leave, Integer> {

}
