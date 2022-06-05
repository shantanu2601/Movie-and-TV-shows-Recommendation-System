package net.codej;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class Movie_User_id implements Serializable {
	
	private int movid;
	private int user_id;
	public Movie_User_id(int movid, int user_id) {
		super();
		this.movid = movid;
		this.user_id = user_id;
	}
	public Movie_User_id() {
		super();
	}
	public int getMovid() {
		return movid;
	}
	public void setMovid(int movid) {
		this.movid = movid;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}
