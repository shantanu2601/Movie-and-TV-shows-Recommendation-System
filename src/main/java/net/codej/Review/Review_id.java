package net.codej.Review;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class Review_id  implements Serializable {
	
	private int revid ;
	private int movid ;
	private int user_id ;
	public Review_id() {
		super();
	}
	public Review_id(int revid, int movid, int user_id) {
		super();
		this.revid = revid;
		this.movid = movid;
		this.user_id = user_id;
	}
	public Review_id( int movid, int user_id) {
		super();
		this.movid = movid;
		this.user_id = user_id;
	}
	public int getRevid() {
		return revid;
	}
	public void setRevid(int revid) {
		this.revid = revid;
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
