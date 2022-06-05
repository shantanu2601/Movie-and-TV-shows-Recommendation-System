package net.codej.Movie;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface MovieRepository extends JpaRepository<Movie,Integer> {



	@Query("SELECT a FROM Movie a WHERE a.movid =?1")
	Movie findMovie(int movid);
	
	@Query("SELECT a FROM Movie a WHERE a.movname LIKE %:movname%")
	List<Movie> findMoviebymovname(@Param("movname") String movname);
	
	@Query("SELECT a FROM Movie a WHERE a.status =?1")
	List<Movie> findMoviebystatus(String status);
	
	@Query("SELECT a FROM Movie a WHERE a.episodes =?1")
	List<Movie> findMoviebyepisodes(int episodes);
	
	@Query("SELECT a FROM Movie a WHERE a.reldate >=?1")
	List<Movie> findMoviebyreldate(Date reldate);
	
	@Query("SELECT a FROM Movie a WHERE a.enddate <=?1")
	List<Movie> findMoviebyenddate(Date enddate);
	
	@Query("SELECT a FROM Movie a WHERE a.duration =?1")
	List<Movie> findMoviebyduration(Time duration);
	
	@Query("SELECT a FROM Movie a WHERE a.rating >=?1")
	List<Movie> findMoviebyrating(double rating);
	
	@Query("SELECT a FROM Movie a")
	List<Movie> findAllMovie();
	
	
	
	
	
	
	
	
	
	
	
	
	


}