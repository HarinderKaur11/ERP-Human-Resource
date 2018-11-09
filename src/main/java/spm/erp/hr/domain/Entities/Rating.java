package spm.erp.hr.domain.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	@OneToOne
//	@JoinColumn(name = "rating_provider")
	private Employee ratingProvider;
	@OneToOne
//	@JoinColumn(name = "rated_employee")
	private Employee ratedEmployee;
	private String typeOfRating;
	private Integer ratingStarCount;
	private String ratingDescription;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Employee getRatingProvider() {
		return ratingProvider;
	}

	public void setRatingProvider(Employee ratingProvider) {
		this.ratingProvider = ratingProvider;
	}

	public Employee getRatedEmployee() {
		return ratedEmployee;
	}

	public void setRatedEmployee(Employee ratedEmployee) {
		this.ratedEmployee = ratedEmployee;
	}

	public String getTypeOfRating() {
		return typeOfRating;
	}

	public void setTypeOfRating(String typeOfRating) {
		this.typeOfRating = typeOfRating;
	}

	public Integer getRatingStarCount() {
		return ratingStarCount;
	}

	public void setRatingStarCount(Integer ratingStarCount) {
		this.ratingStarCount = ratingStarCount;
	}

	public String getRatingDescription() {
		return ratingDescription;
	}

	public void setRatingDescription(String ratingDescription) {
		this.ratingDescription = ratingDescription;
	}

}
