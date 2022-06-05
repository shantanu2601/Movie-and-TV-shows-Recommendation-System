package net.codej.Movie_genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codej.Transfer;
import net.codej.Movie.MovieService;


@Controller
public class Movie_genreController  {


	@Autowired
	private Movie_genreService service;
	@Autowired
	private MovieService mov;
	
	@PostMapping("/MovieGenre")
	public  ModelAndView addMovies(ModelAndView mv, @RequestParam(name="movid") int movid, @RequestParam(name="genre") String genre)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		Movie_genre_id movie_genre_id = new Movie_genre_id(movid, genre);
		Movie_genre m= new Movie_genre();
		m.setMovie_genre_id(movie_genre_id);
		m.setMovie(mov.findMoviebymovid(movid));
		service.save(m);
		mv.setViewName("AdminDashboard");
		return mv;
	}
	
	@GetMapping("/MovieGenre/add")
	public  ModelAndView addMoviesprior(ModelAndView mv)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		mv.setViewName("MovieGenre");
		return mv;
	}
}