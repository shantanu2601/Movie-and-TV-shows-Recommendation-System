package net.codej.Movie_cast;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import net.codej.Movie.Movie;
@EnableAutoConfiguration
@Entity
public class Movie_cast {
	
	@EmbeddedId
	private Movie_cast_id movie_cast_id;
	
	@MapsId("movid")
	@JoinColumn(name = "movid", referencedColumnName = "movid")
	@ManyToOne
	private Movie movie;

	public Movie_cast_id getMovie_cast_id() {
		return movie_cast_id;
	}

	public void setMovie_cast_id(Movie_cast_id movie_cast_id) {
		this.movie_cast_id = movie_cast_id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Movie_cast(Movie_cast_id movie_cast_id, Movie movie) {
		super();
		this.movie_cast_id = movie_cast_id;
		this.movie = movie;
	}

	public Movie_cast() {
		super();
	}

}
