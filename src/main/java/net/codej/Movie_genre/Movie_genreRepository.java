package net.codej.Movie_genre;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface Movie_genreRepository extends JpaRepository<Movie_genre,Movie_genre_id> {

	@Query("SELECT a FROM Movie_genre a WHERE a.movie.movid =?1")
	List<Movie_genre> findGenre(int movid);
	
	@Query("SELECT a FROM Movie_genre a WHERE a.movie_genre_id =?1")
	Movie_genre findIfExist(Movie_genre_id movie_genre_id);


}