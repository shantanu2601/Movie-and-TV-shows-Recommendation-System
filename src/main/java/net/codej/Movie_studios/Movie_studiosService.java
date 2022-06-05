package net.codej.Movie_studios;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Movie_studiosService  {


	@Autowired 
	private Movie_studiosRepository repository;
	
	public List<Movie_studios> findStudios(int user_id)
	{
		return repository.findStudios(user_id);
	}
	
	public Movie_studios findIfExist(int movid, String studios)
	{
		
		Movie_studios_id movie_studios_id= new Movie_studios_id(movid, studios);
		return repository.findIfExist(movie_studios_id);
	}
	
	public Movie_studios save(Movie_studios a)
	{
		return repository.save(a);
		
	}

}