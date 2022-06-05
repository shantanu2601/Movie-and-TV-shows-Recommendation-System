package net.codej.Favourites;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codej.Movie_User_id;


@Service
public class FavouritesService  {

	
	@Autowired 
	private FavouritesRepository repository;
	
	public List<Favourites> findMovies(int user_id)
	{
		return repository.findMovies(user_id);
	}
	
	public Favourites findIfExist( int movid, int user_id)
	{
		
		Movie_User_id movie_user_id= new Movie_User_id(movid, user_id);
		return repository.findIfExist(movie_user_id);
	}
	
	public Favourites save(Favourites a)
	{
		return repository.save(a);
		
	}


}
