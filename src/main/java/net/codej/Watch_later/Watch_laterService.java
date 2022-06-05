package net.codej.Watch_later;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codej.Movie_User_id;


@Service
public class Watch_laterService {

	
	@Autowired 
	private Watch_laterRepository repository;
	
	public List<Watch_later> findMovies(int user_id)
	{
		return repository.findMovies(user_id);
	}
	
	public Watch_later findIfExist( int movid, int user_id)
	{
		
		Movie_User_id movie_user_id= new Movie_User_id(movid, user_id);
		return repository.findIfExist(movie_user_id);
	}
	
	public Watch_later save(Watch_later a)
	{
		return repository.save(a);
		
	}

}
