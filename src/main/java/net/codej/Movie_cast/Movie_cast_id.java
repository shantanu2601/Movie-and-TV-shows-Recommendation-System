package net.codej.Movie_cast;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Movie_cast_id implements Serializable {

	private int movid;
	private String  cast;
	public Movie_cast_id(int movid, String cast) {
		super();
		this.movid = movid;
		this.cast = cast;
	}
	public Movie_cast_id() {
		super();
	}
	public int getMovid() {
		return movid;
	}
	public void setMovid(int movid) {
		this.movid = movid;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	
}
