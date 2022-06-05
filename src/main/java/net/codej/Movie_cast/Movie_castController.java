package net.codej.Movie_cast;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codej.Movie_User_id;
import net.codej.Transfer;
import net.codej.Movie.Movie;
import net.codej.Movie.MovieService;
import net.codej.Watch_later.Watch_later;
import net.codej.Watch_later.Watch_laterService;


@Controller
public class Movie_castController {


	@Autowired
	private Movie_castService service;
	@Autowired
	private MovieService mov;
	
	@PostMapping("/MovieCast")
	public  ModelAndView addMovies(ModelAndView mv, @RequestParam(name="movid") int movid, @RequestParam(name="cast") String cast)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		Movie_cast_id movie_cast_id = new Movie_cast_id(movid, cast);
		Movie_cast m= new Movie_cast();
		m.setMovie_cast_id(movie_cast_id);
		m.setMovie(mov.findMoviebymovid(movid));
		service.save(m);
		mv.setViewName("AdminDashboard");
		return mv;
	}
	
	@GetMapping("/MovieCast/add")
	public  ModelAndView addMoviesprior(ModelAndView mv)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		mv.setViewName("MovieCast");
		return mv;
	}

}