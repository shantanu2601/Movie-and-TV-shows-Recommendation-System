package net.codej.AlreadyWatched;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codej.Movie_User_id;



public interface Already_WatchedRepository extends JpaRepository<Already_Watched,Movie_User_id> {


	@Query("SELECT a FROM Already_Watched a WHERE a.user.user_id =?1")
	List<Already_Watched> findMovies(int user_id);
	
	@Query("SELECT a FROM Already_Watched a WHERE a.movie_user_id =?1")
	Already_Watched findIfExist(Movie_User_id movie_user_id);
	

}