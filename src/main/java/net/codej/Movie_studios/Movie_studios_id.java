package net.codej.Movie_studios;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class Movie_studios_id implements Serializable {

	private int movid;
	private String  studios;
	public Movie_studios_id(int movid, String studios) {
		super();
		this.movid = movid;
		this.studios = studios;
	}
	public int getMovid() {
		return movid;
	}
	public void setMovid(int movid) {
		this.movid = movid;
	}
	public String getStudios() {
		return studios;
	}
	public void setStudios(String studios) {
		this.studios = studios;
	}
	public Movie_studios_id() {
		super();
	}
	
}
