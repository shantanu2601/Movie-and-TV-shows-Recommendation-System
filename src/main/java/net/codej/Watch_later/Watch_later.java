package net.codej.Watch_later;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import net.codej.Movie_User_id;
import net.codej.Movie.Movie;
import net.codej.User.User;
@EnableAutoConfiguration
@Entity
public class Watch_later {
	
	@EmbeddedId
	private Movie_User_id movie_user_id;
	
	@MapsId("movid")
	@JoinColumn(name = "movid", referencedColumnName = "movid")
	@ManyToOne
	private Movie movie;
	
	@MapsId("user_id")
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@ManyToOne
	private User user;
	
	
	public  Watch_later(Movie_User_id movie_user_id, Movie movie, User user) {
		super();
		this.movie_user_id = movie_user_id;
		this.movie = movie;
		this.user = user;
	}


	public Movie_User_id getMovie_user_id() {
		return movie_user_id;
	}


	public void setMovie_user_id(Movie_User_id movie_user_id) {
		this.movie_user_id = movie_user_id;
	}


	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public  Watch_later() {
		super();
	}
	
	
	
	


}
