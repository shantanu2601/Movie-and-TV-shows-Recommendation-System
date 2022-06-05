package net.codej.Favourites;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codej.Movie_User_id;



public interface FavouritesRepository extends JpaRepository<Favourites,Movie_User_id> {

	@Query("SELECT a FROM Favourites a WHERE a.user.user_id =?1")
	List<Favourites> findMovies(int user_id);
	
	@Query("SELECT a FROM Favourites a WHERE a.movie_user_id =?1")
	Favourites findIfExist(Movie_User_id movie_user_id);



}
