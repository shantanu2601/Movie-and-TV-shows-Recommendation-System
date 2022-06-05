package net.codej.Movie_studios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codej.Transfer;
import net.codej.Movie.MovieService;
import net.codej.Movie_cast.Movie_castService;


@Controller
public class Movie_studiosController  {


	@Autowired
	private Movie_studiosService service;
	@Autowired
	private MovieService mov;
	
	@PostMapping("/MovieStudios")
	public  ModelAndView addMovies(ModelAndView mv, @RequestParam(name="movid") int movid, @RequestParam(name="studios") String studios)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		Movie_studios_id movie_studios_id = new Movie_studios_id(movid, studios);
		Movie_studios m= new Movie_studios();
		m.setMovie_studios_id(movie_studios_id);
		m.setMovie(mov.findMoviebymovid(movid));
		service.save(m);
		mv.setViewName("AdminDashboard");
		return mv;
	}
	
	@GetMapping("/MovieStudios/add")
	public  ModelAndView addMoviesprior(ModelAndView mv)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		mv.setViewName("MovieStudios");
		return mv;
	}

}