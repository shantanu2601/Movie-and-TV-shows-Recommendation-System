package net.codej.Movie_cast;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface Movie_castRepository extends JpaRepository<Movie_cast,Movie_cast_id> {

	@Query("SELECT a FROM Movie_cast a WHERE a.movie.movid =?1")
	List<Movie_cast> findCast(int movid);
	
	@Query("SELECT a FROM Movie_cast a WHERE a.movie_cast_id =?1")
	Movie_cast findIfExist(Movie_cast_id movie_cast_id);

}