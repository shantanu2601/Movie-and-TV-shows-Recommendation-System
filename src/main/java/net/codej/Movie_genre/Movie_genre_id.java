package net.codej.Movie_genre;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class Movie_genre_id implements Serializable {

	private int movid;
	private String  genre;
	public Movie_genre_id(int movid, String genre) {
		super();
		this.movid = movid;
		this.genre = genre;
	}
	public Movie_genre_id() {
		super();
	}
	public int getMovid() {
		return movid;
	}
	public void setMovid(int movid) {
		this.movid = movid;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
