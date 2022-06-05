package net.codej.Favourites;

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
public class FavouritesController  {

	
	@Autowired
	private FavouritesService service;
	@Autowired
	private MovieService mov;
	
	@GetMapping("/FavouritesMovies")
	public  ModelAndView findAllMovies(ModelAndView mv)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		mv.addObject("list", service.findMovies(Transfer.getId()));            
		mv.setViewName("FavouritesMovies");
		 return mv;
	}
	
	
	@GetMapping("/FavouritesMovies/search")
	public  ModelAndView searchMovies(ModelAndView mv, @RequestParam(name="movname") String movname)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		List<Favourites> fav =service.findMovies(Transfer.getId());
		List<Favourites> m= new ArrayList<Favourites>();
		for(Favourites f:fav)
		{
			if(f.getMovie().getMovname().contains(movname))
				m.add(f);
		}
		mv.addObject("list", m);            
		mv.setViewName("FavouritesMoviesSearch");
		 return mv;
	}
	
	@PostMapping("/FavouritesMovies/add")
	public  ModelAndView addMovies(ModelAndView mv, @RequestParam(name="movid") int movid)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		Movie_User_id movie_user_id = new Movie_User_id(movid, Transfer.getId());
		Favourites fav= new Favourites();
		fav.setMovie_user_id(movie_user_id);
		Movie m =mov.findMoviebymovid(movid);
		fav.setMovie(m);
		fav.setUser(Transfer.getUser());
		service.save(fav);
		mv.addObject("list", service.findMovies(Transfer.getId())); 
		mv.setViewName("FavouritesMovies");
		return mv;
	}




}
