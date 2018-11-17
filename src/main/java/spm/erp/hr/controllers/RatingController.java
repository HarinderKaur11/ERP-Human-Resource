package spm.erp.hr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spm.erp.hr.domain.Entities.Rating;
import spm.erp.hr.services.RatingService;

/**
 * The Class RatingController.
 */
@RestController
@RequestMapping(value = "/rating")
public class RatingController {

	/** The rating service. */
	@Autowired
	private RatingService ratingService;

	/**
	 * Adds the rating.
	 *
	 * @param ratedBy  the rated by
	 * @param ratedFor the rated for
	 * @param rating   the rating
	 * @return the rating
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public Rating addRating(@RequestParam("ratedby") Integer ratedBy, @RequestParam("ratedfor") Integer ratedFor,
			@RequestBody Rating rating) {
		return ratingService.addRatingForEmployee(ratedBy, ratedFor, rating);
	}

	/**
	 * Gets the rating for employee.
	 *
	 * @param empId the emp id
	 * @return the rating for employee
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Rating> getRatingForEmployee(@RequestParam("empid") Integer empId) {
		return ratingService.getRatingforEmployee(empId);
	}
}
