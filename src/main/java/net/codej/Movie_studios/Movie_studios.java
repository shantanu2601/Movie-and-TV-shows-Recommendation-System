package net.codej.Movie_studios;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import net.codej.Movie.Movie;
@EnableAutoConfiguration
@Entity
public class Movie_studios {

	@EmbeddedId
	private Movie_studios_id movie_studios_id;
	
	@MapsId("movid")
	@JoinColumn(name = "movid", referencedColumnName = "movid")
	@ManyToOne
	private Movie movie;

	public Movie_studios_id getMovie_studios_id() {
		return movie_studios_id;
	}

	public void setMovie_studios_id(Movie_studios_id movie_studios_id) {
		this.movie_studios_id = movie_studios_id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Movie_studios(Movie_studios_id movie_studios_id, Movie movie) {
		super();
		this.movie_studios_id = movie_studios_id;
		this.movie = movie;
	}

	public Movie_studios() {
		super();
	}

	
	

}
