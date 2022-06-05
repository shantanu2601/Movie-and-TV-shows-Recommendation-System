package net.codej.Connected;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codej.Movie.MovieService;


@Controller
public class ConnectedController  {

	@Autowired
	private ConnectedService service;
	@Autowired
	private MovieService mov;

	@PostMapping("/Connected")
	public  ModelAndView addMovies(ModelAndView mv, @RequestParam(name="movid") int movid, @RequestParam(name="rel_id") int rel_id)
	{
		
		Connected_id connected_id = new Connected_id(movid, rel_id);
		Connected m= new Connected();
		m.setConnected_id( connected_id);
		m.setMovie(mov.findMoviebymovid(movid));
		m.setRel(mov.findMoviebymovid(rel_id));
		service.save(m);
		mv.setViewName("AdminDashboard");
		return mv;
	}
	@GetMapping("/Connected/add")
	public  ModelAndView addConMovies(ModelAndView mv)
	{
		
		mv.setViewName("Connected");
		return mv;
	}

}