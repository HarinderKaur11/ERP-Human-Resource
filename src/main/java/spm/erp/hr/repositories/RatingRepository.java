package spm.erp.hr.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import spm.erp.hr.domain.Entities.Employee;
import spm.erp.hr.domain.Entities.Rating;

public interface RatingRepository extends CrudRepository<Rating, Integer> {

	public List<Rating> findByRatedEmployee(Employee employee);

	public Rating findByRatingProviderAndRatedEmployee(Employee ratingProvider, Employee ratedReceiver);
}
