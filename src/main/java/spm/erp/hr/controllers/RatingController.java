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

@RestController
@RequestMapping(value = "/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@RequestMapping(method = RequestMethod.PUT)
	public Rating addRating(@RequestParam("ratedby") Integer ratedBy, @RequestParam("ratedfor") Integer ratedFor,
			@RequestBody Rating rating) {
		return ratingService.addRatingForEmployee(ratedBy, ratedFor, rating);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Rating> getRatingForEmployee(@RequestParam("empid") Integer empId) {
		return ratingService.getRatingforEmployee(empId);
	}
}
