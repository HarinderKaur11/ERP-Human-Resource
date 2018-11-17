package spm.erp.hr.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import spm.erp.hr.domain.Entities.Employee;
import spm.erp.hr.domain.Entities.Rating;

/**
 * The Interface RatingRepository.
 */
public interface RatingRepository extends CrudRepository<Rating, Integer> {

	/**
	 * Find by rated employee.
	 *
	 * @param employee the employee
	 * @return the list
	 */
	public List<Rating> findByRatedEmployee(Employee employee);

	/**
	 * Find by rating provider and rated employee.
	 *
	 * @param ratingProvider the rating provider
	 * @param ratedReceiver  the rated receiver
	 * @return the rating
	 */
	public Rating findByRatingProviderAndRatedEmployee(Employee ratingProvider, Employee ratedReceiver);
}
