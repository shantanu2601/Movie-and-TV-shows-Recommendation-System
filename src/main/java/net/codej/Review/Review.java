package net.codej.Review;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import net.codej.Movie.Movie;
import net.codej.User.User;
@EnableAutoConfiguration
@Entity
public class Review {
	
	@EmbeddedId
	private Review_id review_id ;
	@MapsId("movid")
	@JoinColumn(name="movid", referencedColumnName="movid")
	@ManyToOne
	private Movie movie;
	
	@MapsId("user_id")
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	@ManyToOne
	private User user;
	@Column(columnDefinition = "TEXT")
	private String review;
	public Review() {
		super();
	}
	
	
	public Review(Review_id review_id, Movie movie, User user, String review) {
		super();
		this.review_id = review_id;
		this.movie = movie;
		this.user = user;
		this.review = review;
	}

	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Review_id getReview_id() {
		return review_id;
	}
	public void setReview_id(Review_id review_id) {
		this.review_id = review_id;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}

}
