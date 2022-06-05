package net.codej.Watch_later;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codej.Movie_User_id;



public interface Watch_laterRepository extends JpaRepository< Watch_later,Movie_User_id> {

	@Query("SELECT a FROM Watch_later a WHERE a.user.user_id =?1")
	List<Watch_later> findMovies(int user_id);
	
	@Query("SELECT a FROM Watch_later a WHERE a.movie_user_id =?1")
	Watch_later findIfExist(Movie_User_id movie_user_id);
	



}
