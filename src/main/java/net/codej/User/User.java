package net.codej.User;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import net.codej.AlreadyWatched.Already_Watched;
import net.codej.Favourites.Favourites;
import net.codej.Review.Review;
import net.codej.User_Login.User_Login;
import net.codej.Watch_later.Watch_later;
@EnableAutoConfiguration
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	private String fname;
	private String lname;
	private Date joindate;
	private String State;
	@OneToMany(mappedBy = "user")
	private Collection<Favourites> favourites;
	@OneToMany(mappedBy = "user")
	private Collection<Watch_later> watch_later;
	@OneToMany(mappedBy = "user")
	private Collection<Already_Watched> already_watched;
	@OneToMany(mappedBy = "user")
	private Collection<Review> review;
	@OneToOne(mappedBy = "user")
	private User_Login user_login;
	public User() {
		super();
	}
	
	public User(int user_id, String fname, String lname, Date joindate, String state, Collection<Favourites> favourites,
			Collection<Watch_later> watch_later, Collection<Already_Watched> already_watched, Collection<Review> review,
			User_Login user_login) {
		super();
		this.user_id = user_id;
		this.fname = fname;
		this.lname = lname;
		this.joindate = joindate;
		State = state;
		this.favourites = favourites;
		this.watch_later = watch_later;
		this.already_watched = already_watched;
		this.review = review;
		this.user_login = user_login;
	}

	public User( String fname, String lname, Date joindate, String state) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.joindate = joindate;
		State = state;
	}
	
	public Collection<Favourites> getFavourites() {
		return favourites;
	}

	public void setFavourites(Collection<Favourites> favourites) {
		this.favourites = favourites;
	}

	public Collection<Watch_later> getWatch_later() {
		return watch_later;
	}

	public void setWatch_later(Collection<Watch_later> watch_later) {
		this.watch_later = watch_later;
	}

	public Collection<Already_Watched> getAlready_watched() {
		return already_watched;
	}

	public void setAlready_watched(Collection<Already_Watched> already_watched) {
		this.already_watched = already_watched;
	}

	public Collection<Review> getReview() {
		return review;
	}

	public void setReview(Collection<Review> review) {
		this.review = review;
	}

	public User_Login getUser_login() {
		return user_login;
	}

	public void setUser_login(User_Login user_login) {
		this.user_login = user_login;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	

}
