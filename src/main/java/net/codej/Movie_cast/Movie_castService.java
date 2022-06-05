package net.codej.Movie_cast;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Movie_castService {

	@Autowired 
	private Movie_castRepository repository;
	
	public List<Movie_cast> findCast(int user_id)
	{
		return repository.findCast(user_id);
	}
	
	public Movie_cast findIfExist(int movid, String cast)
	{
		
		Movie_cast_id movie_cast_id= new Movie_cast_id(movid, cast);
		return repository.findIfExist(movie_cast_id);
	}
	
	public Movie_cast save(Movie_cast a)
	{
		return repository.save(a);
		
	}

}