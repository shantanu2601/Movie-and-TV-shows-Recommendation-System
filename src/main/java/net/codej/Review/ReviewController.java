package net.codej.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.codej.Transfer;
import net.codej.Movie.Movie;
import net.codej.Movie.MovieService;


@RestController
public class ReviewController  {
	
	@Autowired
	private ReviewService service;
	@Autowired
	private MovieService mov;
	
	@GetMapping("/Review/Movie")
	public  ModelAndView findByMovies(ModelAndView mv, @RequestParam(name="movid") int movid)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		mv.addObject("list", service.findReviewBymovid(movid));            
		mv.setViewName("ReviewMovie");
		 return mv;
	}
	
	@GetMapping("/Review/User")
	public  ModelAndView findByUser(ModelAndView mv, @RequestParam(name="user_id") int user_id)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		mv.addObject("list", service.findReviewByuser_id(user_id));            
		mv.setViewName("ReviewUser");
		 return mv;
	}	

	

	@PostMapping("/Review/add")
	public  ModelAndView addMovies(ModelAndView mv ,@RequestParam(name="movid") int movid,@RequestParam(name="Review") String Review)
	{
		
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		int count= service.findReviewCount(Transfer.getId(), movid);
		Review_id review_id = new Review_id(count+1,movid, Transfer.getId());
		Review watch= new Review();
		watch.setReview(Review);
		watch.setReview_id(review_id);
		Movie m =mov.findMoviebymovid(movid);
		watch.setUser(Transfer.getUser());
		watch.setMovie(m);
		service.save(watch);
		m =mov.findMoviebymovid(movid);
		mv.addObject("Movie",m);
		mv.setViewName("Movie");
		return mv;
	}



	
}