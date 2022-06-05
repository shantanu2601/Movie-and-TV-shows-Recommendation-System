package net.codej.Movie;


import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import net.codej.AlreadyWatched.Already_Watched;
import net.codej.Connected.Connected;
import net.codej.Favourites.Favourites;
import net.codej.Movie_cast.Movie_cast;
import net.codej.Movie_genre.Movie_genre;
import net.codej.Movie_studios.Movie_studios;
import net.codej.Review.Review;
import net.codej.Watch_later.Watch_later;
@EnableAutoConfiguration
@Entity

public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movid")
	private int movid;
	private String movname;
	private String status;
	private int episodes;
	@Temporal(TemporalType.DATE)
	private Date reldate;
	@Temporal(TemporalType.DATE)
	private Date enddate;
	private Time duration;
	private double rating;
	private int no_of_fav ;
	@Column(columnDefinition = "TEXT")
	private String sypnosis;
	private String image;
	
	@OneToMany(mappedBy = "movie")
	private Collection<Movie_genre> movie_genre;
	@OneToMany(mappedBy = "movie")
	private Collection<Movie_cast> movie_cast;
	@OneToMany(mappedBy = "movie")
	private Collection<Movie_studios> movie_studios;
	@OneToMany(mappedBy = "movie")
	private Collection<Favourites> favourites;
	@OneToMany(mappedBy = "movie")
	private Collection<Watch_later> watch_later;
	@OneToMany(mappedBy = "movie")
	private Collection<Already_Watched> already_watched;
	@OneToMany(mappedBy = "movie")
	private Collection<Connected> connected_movie;
	@OneToMany(mappedBy = "rel")
	private Collection<Connected> connected_rel;
	@OneToMany(mappedBy = "movie")
	private Collection<Review> review;
	
	
	
	public Movie() {
		super();
	}
	



	public String getSypnosis() {
		return sypnosis;
	}




	public Movie(int movid, String movname, String status, int episodes, Date reldate, Date enddate, Time duration,
			double rating, int no_of_fav, String sypnosis, String image, Collection<Movie_genre> movie_genre,
			Collection<Movie_cast> movie_cast, Collection<Movie_studios> movie_studios,
			Collection<Favourites> favourites, Collection<Watch_later> watch_later,
			Collection<Already_Watched> already_watched, Collection<Connected> connected_movie,
			Collection<Connected> connected_rel, Collection<Review> review) {
		super();
		this.movid = movid;
		this.movname = movname;
		this.status = status;
		this.episodes = episodes;
		this.reldate = reldate;
		this.enddate = enddate;
		this.duration = duration;
		this.rating = rating;
		this.no_of_fav = no_of_fav;
		this.sypnosis = sypnosis;
		this.image = image;
		this.movie_genre = movie_genre;
		this.movie_cast = movie_cast;
		this.movie_studios = movie_studios;
		this.favourites = favourites;
		this.watch_later = watch_later;
		this.already_watched = already_watched;
		this.connected_movie = connected_movie;
		this.connected_rel = connected_rel;
		this.review = review;
	}




	public void setSypnosis(String sypnosis) {
		this.sypnosis = sypnosis;
	}




	public Movie(String status, int episodes, Date reldate, Date enddate, Time duration, double rating,
			String movname) {
		super();
		this.status = status;
		this.episodes = episodes;
		this.reldate = reldate;
		this.enddate = enddate;
		this.duration = duration;
		this.rating = rating;
		this.movname = movname;
	}




	public Movie(int movid, String status, int episodes, Date reldate, Date enddate, Time duration, double rating,
			int no_of_fav, String movname, String image, Collection<Movie_genre> movie_genre,
			Collection<Movie_cast> movie_cast, Collection<Movie_studios> movie_studios,
			Collection<Favourites> favourites, Collection<Watch_later> watch_later,
			Collection<Already_Watched> already_watched, Collection<Connected> connected_movie,
			Collection<Connected> connected_rel, Collection<Review> review) {
		super();
		this.movid = movid;
		this.status = status;
		this.episodes = episodes;
		this.reldate = reldate;
		this.enddate = enddate;
		this.duration = duration;
		this.rating = rating;
		this.no_of_fav = no_of_fav;
		this.movname = movname;
		this.image = image;
		this.movie_genre = movie_genre;
		this.movie_cast = movie_cast;
		this.movie_studios = movie_studios;
		this.favourites = favourites;
		this.watch_later = watch_later;
		this.already_watched = already_watched;
		this.connected_movie = connected_movie;
		this.connected_rel = connected_rel;
		this.review = review;
	}






	public Movie( String status, int episodes, Date reldate, Date enddate, Time duration, double rating,
			int no_of_fav, String movname, String image) {
		super();
		this.status = status;
		this.episodes = episodes;
		this.reldate = reldate;
		this.enddate = enddate;
		this.duration = duration;
		this.rating = rating;
		this.no_of_fav = no_of_fav;
		this.movname = movname;
		this.image=image;
	}


	


	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}




	public Collection<Review> getReview() {
		return review;
	}









	public void setReview(Collection<Review> review) {
		this.review = review;
	}









	public int getMovid() {
		return movid;
	}




	public void setMovid(int movid) {
		this.movid = movid;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public int getEpisodes() {
		return episodes;
	}




	public void setEpisodes(int episodes) {
		this.episodes = episodes;
	}




	public Date getReldate() {
		return reldate;
	}




	public void setReldate(Date reldate) {
		this.reldate = reldate;
	}




	public Date getEnddate() {
		return enddate;
	}




	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}




	public Time getDuration() {
		return duration;
	}




	public void setDuration(Time duration) {
		this.duration = duration;
	}




	public double getRating() {
		return rating;
	}




	public void setRating(double rating) {
		this.rating = rating;
	}




	public int getNo_of_fav() {
		return no_of_fav;
	}




	public void setNo_of_fav(int no_of_fav) {
		this.no_of_fav = no_of_fav;
	}




	public String getMovname() {
		return movname;
	}




	public void setMovname(String movname) {
		this.movname = movname;
	}




	public Collection<Movie_genre> getMovie_genre() {
		return movie_genre;
	}




	public void setMovie_genre(Collection<Movie_genre> movie_genre) {
		this.movie_genre = movie_genre;
	}




	public Collection<Movie_cast> getMovie_cast() {
		return movie_cast;
	}




	public void setMovie_cast(Collection<Movie_cast> movie_cast) {
		this.movie_cast = movie_cast;
	}




	public Collection<Movie_studios> getMovie_studios() {
		return movie_studios;
	}




	public void setMovie_studios(Collection<Movie_studios> movie_studios) {
		this.movie_studios = movie_studios;
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




	public Collection<Connected> getConnected_movie() {
		return connected_movie;
	}




	public void setConnected_movie(Collection<Connected> connected_movie) {
		this.connected_movie = connected_movie;
	}




	public Collection<Connected> getConnected_rel() {
		return connected_rel;
	}




	public void setConnected_rel(Collection<Connected> connected_rel) {
		this.connected_rel = connected_rel;
	}

	

}
