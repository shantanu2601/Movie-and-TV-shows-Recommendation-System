package net.codej.Movie;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MovieService  {


	@Autowired 
	private  MovieRepository repository;
	
	public List<Movie> intersection(List<Movie> m1, List<Movie> m2)
	
	{
		List<Movie> sub = new ArrayList<Movie>();
		for(Movie mv1:m1)  
			{
				for(Movie mv2:m2)  
				{ 
					if(mv1.getMovid()== mv2.getMovid()) 
						sub.add(mv1);
				}   	  
			}  
		
		return sub;
	}
	
	public  Movie findMoviebymovid(int movid)

	{
		return repository.findMovie(movid);
	}
	
	public  List<Movie> findMoviebymovname(String movname, List<Movie> m)

	{
		return intersection(m,repository.findMoviebymovname( movname));
	}
	
	public List<Movie> findMoviebystatus(String status,  List<Movie> m)
	{
		return intersection(m,repository.findMoviebystatus(status));
		
	}
	
	public List<Movie> findMoviebyepisodes(int episodes,List<Movie> m)
	{
		return intersection(m,repository.findMoviebyepisodes(episodes));
	}
	
	public List<Movie> findMoviebyreldate(Date reldate,List<Movie> m)
	{
		
		return intersection(m,repository.findMoviebyreldate(reldate));
	}
	
	public List<Movie> findMoviebyenddate(Date enddate,List<Movie> m)
	{
		return intersection(m,repository.findMoviebyenddate(enddate));
	}
	
	public List<Movie> findMoviebyduration(Time duration,List<Movie> m)
	{
		return intersection(m,repository.findMoviebyduration( duration));
	}
	
	public List<Movie> findMoviebyrating(double rating,List<Movie> m)
	{
		return intersection(m,repository.findMoviebyrating(rating));
	}
	
	public List<Movie> findAllMovie()
	{
		return  repository.findAllMovie();
	}
	
	public List<Movie> searchMovie(Movie mv)
	{
		List<Movie> m = findAllMovie();
		if(!mv.getMovname().equals(""))
		m= findMoviebymovname(mv.getMovname(),m);
		if(!mv.getStatus().equals(""))
		m= findMoviebystatus(mv.getStatus(),m);
		if(mv.getEpisodes()!=0)
		m= findMoviebyepisodes(mv.getEpisodes(),m);
		if(mv.getReldate()!=null)
		m= findMoviebyreldate(mv.getReldate(),m);
		if(mv.getEnddate()!=null)
		m= findMoviebyenddate(mv.getEnddate(),m);
		if(mv.getDuration()!=null)
		m= findMoviebyduration(mv.getDuration(),m);
		if(mv.getRating()!=0)
		m= findMoviebyrating(mv.getRating(),m);
		
		return m;
	}
	
	
	public  Movie save( Movie a)
	{
		return repository.save(a);
		
	}

}