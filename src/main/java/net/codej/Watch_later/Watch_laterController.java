package net.codej.Watch_later;

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


@Controller
public class Watch_laterController {

	

	@Autowired
	private Watch_laterService service;
	@Autowired
	private MovieService mov;
	
	@GetMapping("/WatchLaterMovies")
	public  ModelAndView findAllMovies(ModelAndView mv)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		mv.addObject("list", service.findMovies(Transfer.getId()));      
		mv.setViewName("WatchLaterMovies");
		 return mv;
	}
	
	
	@GetMapping("/WatchLaterMovies/search")
	public  ModelAndView searchMovies(ModelAndView mv, @RequestParam(name="movname") String movname)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		List<Watch_later> watch =service.findMovies(Transfer.getId());
		List<Watch_later> m= new ArrayList<Watch_later>();
		for(Watch_later w:watch)
		{
			if(w.getMovie().getMovname().contains(movname))
				m.add(w);
		}
		mv.addObject("list", m);            
		mv.setViewName("WatchLaterMoviesSearch");
		 return mv;
	}
	
	@PostMapping("/WatchLaterMovies/add")
	public  ModelAndView addMovies(ModelAndView mv, @RequestParam(name="movid") int movid)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		Movie_User_id movie_user_id = new Movie_User_id(movid, Transfer.getId());
		Watch_later watch= new Watch_later();
		watch.setMovie_user_id(movie_user_id);
		Movie m =mov.findMoviebymovid(movid);
		watch.setMovie(m);
		watch.setUser(Transfer.getUser());
		service.save(watch);
		mv.addObject("list", service.findMovies(Transfer.getId()));    
		mv.setViewName("WatchLaterMovies");
		return mv;
	}
	
	



}
