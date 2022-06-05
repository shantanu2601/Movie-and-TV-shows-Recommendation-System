package net.codej.Movie_genre;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import net.codej.Movie.Movie;
@EnableAutoConfiguration
@Entity

public class Movie_genre {
	
	
	@EmbeddedId
	private Movie_genre_id movie_genre_id;
	
	@MapsId("movid")
	@JoinColumn(name = "movid", referencedColumnName = "movid")
	@ManyToOne
	private Movie movie;

	public Movie_genre_id getMovie_genre_id() {
		return movie_genre_id;
	}

	public void setMovie_genre_id(Movie_genre_id movie_genre_id) {
		this.movie_genre_id = movie_genre_id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Movie_genre(Movie_genre_id movie_genre_id, Movie movie) {
		super();
		this.movie_genre_id = movie_genre_id;
		this.movie = movie;
	}

	public Movie_genre() {
		super();
	}
	
	
	
	
	

	

}
