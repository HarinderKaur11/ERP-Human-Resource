package spm.erp.hr.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spm.erp.hr.domain.Entities.Employee;
import spm.erp.hr.domain.Entities.Rating;
import spm.erp.hr.enums.RatingType;
import spm.erp.hr.repositories.RatingRepository;

@Service
public class RatingService {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private RatingRepository ratingRepository;

	public Rating addRatingForEmployee(Integer ratedBy, Integer ratedfor, Rating rating) {
		ratingCheck(rating);
		Employee ratingProvider = employeeService.getEmployee(ratedBy);
		Employee ratedReceiver = employeeService.getEmployee(ratedfor);

		if (rating.getTypeOfRating() == RatingType.RATING) {
			if (employeeService.getSubordinates(ratedBy).contains(ratedReceiver)) {
				return saveRating(rating, ratingProvider, ratedReceiver);
			} else {
				throw new IllegalArgumentException(
						String.format("EmpId: %s is not subordinate of EmpId: %s", ratedfor, ratedBy));
			}

		} else if (rating.getTypeOfRating() == RatingType.FEEDBACK) {
			if (employeeService.getSupervisor(ratedBy).equals(ratedReceiver)) {
				return saveRating(rating, ratingProvider, ratedReceiver);
			} else {
				throw new IllegalArgumentException(
						String.format("EmpId: %s is not supervisor of EmpId: %s", ratedfor, ratedBy));
			}
		} else {
			throw new IllegalArgumentException("Incorrect Rating type");
		}
	}

	private Rating saveRating(Rating rating, Employee ratingProvider, Employee ratedReceiver) {
		Rating oldRating = ratingRepository.findByRatingProviderAndRatedEmployee(ratingProvider, ratedReceiver);
		if (Objects.nonNull(oldRating)) {
			rating.setId(oldRating.getId());
		}
		rating.setRatedEmployee(ratedReceiver);
		rating.setRatingProvider(ratingProvider);
		return ratingRepository.save(rating);
	}

	private void ratingCheck(Rating rating) {
		if (Objects.isNull(rating.getRatingStarCount()) || rating.getRatingStarCount() < 1
				|| rating.getRatingStarCount() > 5) {
			throw new IllegalArgumentException("Rating must be between 1 to 5");
		}

	}

	public List<Rating> getRatingforEmployee(Integer emp) {
		return ratingRepository.findByRatedEmployee(employeeService.getEmployee(emp));
	}

}
