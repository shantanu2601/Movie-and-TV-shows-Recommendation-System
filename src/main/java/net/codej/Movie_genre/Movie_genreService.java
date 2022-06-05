package net.codej.Movie_genre;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Movie_genreService  {


	@Autowired 
	private Movie_genreRepository repository;
	
	public List<Movie_genre> findGenre(int user_id)
	{
		return repository.findGenre(user_id);
	}
	
	public Movie_genre findIfExist(int movid, String genre)
	{
		
		Movie_genre_id movie_genre_id= new Movie_genre_id(movid, genre);
		return repository.findIfExist(movie_genre_id);
	}
	
	public Movie_genre save(Movie_genre a)
	{
		return repository.save(a);
		
	}

}