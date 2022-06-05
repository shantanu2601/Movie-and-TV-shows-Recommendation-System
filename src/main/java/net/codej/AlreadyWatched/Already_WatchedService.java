package net.codej.AlreadyWatched;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codej.Movie_User_id;

@Service
public class Already_WatchedService {


	@Autowired 
	private Already_WatchedRepository repository;
	
	public List<Already_Watched> findMovies(int user_id)
	{
		return repository.findMovies(user_id);
	}
	
	public Already_Watched findIfExist( int movid, int user_id)
	{
		
		Movie_User_id movie_user_id= new Movie_User_id(movid, user_id);
		return repository.findIfExist(movie_user_id);
	}
	
	public Already_Watched save(Already_Watched a)
	{
		return repository.save(a);
		
	}
	

}