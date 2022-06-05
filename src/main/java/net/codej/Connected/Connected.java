package net.codej.Connected;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import net.codej.Movie.Movie;
@EnableAutoConfiguration
@Entity
public class Connected {
	
	@EmbeddedId
	private Connected_id connected_id;
	
	@MapsId("movid")
	@JoinColumn(name="movid", referencedColumnName="movid")
	@ManyToOne
	private Movie movie;
	
	@MapsId("rel_id")
    @JoinColumn(name = "rel_id", referencedColumnName = "movid")
	@ManyToOne
	private Movie rel;

	public Connected_id getConnected_id() {
		return connected_id;
	}

	public void setConnected_id(Connected_id connected_id) {
		this.connected_id = connected_id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Movie getRel() {
		return rel;
	}

	public void setRel(Movie rel) {
		this.rel = rel;
	}

	public Connected(Connected_id connected_id, Movie movie, Movie rel) {
		super();
		this.connected_id = connected_id;
		this.movie = movie;
		this.rel = rel;
	}

	public Connected() {
		super();
	}
	
	
	





}
