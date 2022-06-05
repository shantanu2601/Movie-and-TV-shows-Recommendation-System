package net.codej.Movie_studios;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface Movie_studiosRepository extends JpaRepository<Movie_studios,Movie_studios_id> {


	@Query("SELECT a FROM Movie_studios a WHERE a.movie.movid =?1")
	List<Movie_studios> findStudios(int movid);
	
	@Query("SELECT a FROM Movie_studios a WHERE a.movie_studios_id =?1")
	Movie_studios findIfExist(Movie_studios_id movie_studios_id);

}