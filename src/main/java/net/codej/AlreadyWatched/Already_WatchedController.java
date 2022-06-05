package net.codej.AlreadyWatched;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.codej.Movie_User_id;
import net.codej.Transfer;
import net.codej.Movie.Movie;
import net.codej.Movie.MovieService;


@RestController
public class Already_WatchedController {


	@Autowired
	private Already_WatchedService service;
	@Autowired
	private MovieService mov;
	
	@GetMapping("/AlreadyWatchedMovies")
	public  ModelAndView findAllMovies(ModelAndView mv)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		mv.addObject("list", service.findMovies(Transfer.getId()));            
		mv.setViewName("AlreadyWatchedMovies");
		 return mv;
	}
	
	
	@GetMapping("/AlreadyWatchedMovies/search")
	public  ModelAndView searchMovies(ModelAndView mv, @RequestParam(name="movname") String movname)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		List<Already_Watched> fav =service.findMovies(Transfer.getId());
		List<Already_Watched> m= new ArrayList<Already_Watched>();
		for(Already_Watched f:fav)
		{
			if(f.getMovie().getMovname().contains(movname))
				m.add(f);
		}
		mv.addObject("list", m);            
		mv.setViewName("AlreadyWatchedMoviesSearch");
		 return mv;
	}
	
	@PostMapping("/AlreadyWatchedMovies/add")
	public  ModelAndView addMovies(ModelAndView mv, @RequestParam(name="movid") int movid)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		Movie_User_id movie_user_id = new Movie_User_id(movid, Transfer.getId());
		Already_Watched fav= new Already_Watched();
		fav.setMovie_user_id(movie_user_id);
		Movie m =mov.findMoviebymovid(movid);
		fav.setUser(Transfer.getUser());
		fav.setMovie(m);
		service.save(fav);
		mv.addObject("list", service.findMovies(Transfer.getId()));            
		mv.setViewName("AlreadyWatchedMovies");
		return mv;
	}


}