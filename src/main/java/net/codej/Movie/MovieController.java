package net.codej.Movie;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codej.Transfer;
import net.codej.Connected.Connected;
import net.codej.Movie_cast.Movie_cast;
import net.codej.Movie_genre.Movie_genre;
import net.codej.Movie_studios.Movie_studios;


@Controller
public class MovieController  {


	@Autowired
	private MovieService service;
	
	@GetMapping("/Movie")
	public  ModelAndView displayMovie(ModelAndView mv,@RequestParam(name="movid") int movid)
	{
		
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		if(Transfer.getId()==100)
		{
			mv.addObject("Movie", service.findMoviebymovid(movid));            
			mv.setViewName("AdminMovie");
			return mv;
			
		}
		Movie m=service.findMoviebymovid(movid);
//		Path currentPath= Paths.get(".");
//		Path absolutePath =currentPath.toAbsolutePath();
//	
//		m.setImage(absolutePath.toString()+ "/src/main/resources/static/photos/" + m.getImage());
//		System.out.println(m.getImage());
		mv.addObject("Movie", m);            
		mv.setViewName("Movie");
		 return mv;
	}
	
	
	@GetMapping("/Movie/search")
	public  ModelAndView searchMovies(ModelAndView mv, @RequestParam(required = false,name="movname") String movname ,
			@RequestParam(required = false,name="stage") String stage , @RequestParam(required = false,defaultValue = "0",name="episodes") int episodes ,
			@RequestParam(required = false,name="reldate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  Date reldate, @RequestParam(required = false ,name="enddate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date enddate ,
			@RequestParam(required = false,name="duration")  String duration , @RequestParam(required = false,defaultValue = "0",name="rating") double rating,
			@RequestParam(required = false,name="genre") String genre , @RequestParam(required = false,name="cast") String cast,
			@RequestParam(required = false,name="studios") String studios)
	{
		Time ti;
		if(duration!=null&&!duration.equals(""))
		{
			duration = "00:"+duration;
			ti = Time.valueOf(duration);
		}
		else
		{
			ti=null;
		}
		
		
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		if(Transfer.getId()==100)
		{
			List<Movie> mov =service.findAllMovie();
			mv.addObject("list", mov);            
			mv.setViewName("AdminMovieSearch");
			return mv;
			
		}
		Movie max = new Movie(stage, episodes, reldate, enddate, ti, rating, movname);
		List<Movie> mov =service.searchMovie(max);
		List<Movie> fin= new ArrayList<Movie>();
		
		for( Movie m:mov)
		{
			int temp =1;
			if(!genre.equals("")&&temp!=0)
			{
				for (Movie_genre t: m.getMovie_genre())
					
				{
					if(t.getMovie_genre_id().getGenre().equals(genre))
					{
						temp=1;
						break;
					}
					else
					temp=0;
				}
				
			}
			if(!studios.equals("")&&temp!=0)
			{
				
			
				for (Movie_studios t: m.getMovie_studios())
				{
					if(t.getMovie_studios_id().getStudios().equals(studios))
					{
						temp=1;
						break;
					}
					else
					temp=0;
					
				}
			}
			
			if(!cast.equals("")&&temp!=0)
			{
				
		
				for (Movie_cast t: m.getMovie_cast())
				{
					if(t.getMovie_cast_id().getCast().equals(cast))
					{
						temp=1;
						break;
					}
					else
					temp=0;
				}
			
			}
			if(temp==1)
			fin.add(m);
		}
		
		mv.addObject("list", fin);            
		mv.setViewName("MovieSearch");
		 return mv;
	}
	
	@GetMapping("/Related")
	public  ModelAndView Related(ModelAndView mv, @RequestParam(name="movid") int movid )
	{
		
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		
		
		Movie m=service.findMoviebymovid(movid);
		mv.addObject("movid", movid);
		Collection<Connected> c=m.getConnected_movie();
		mv.addObject("list", c);
		if(Transfer.getId()==100)
		{
			mv.setViewName("AdminRelated");	
			return mv;
		}
		else
		mv.setViewName("Related");
		 return mv;
	}
	
	@PostMapping("/Movie/add")
	public  ModelAndView addMovie(ModelAndView mv, @RequestParam(required = false ,name="movname") String movname ,
			@RequestParam(required = false ,name="stage" ) String stage , @RequestParam(name="episodes") int episodes ,
			@RequestParam(required = false,name="reldate")  @DateTimeFormat(pattern = "yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE)Date reldate,
			@RequestParam(required = false,name="enddate")  @DateTimeFormat(pattern = "yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE) Date enddate ,
			@RequestParam(required = false,name="duration") String duration ,
			@RequestParam(required = false,name="rating") double rating,
			@RequestParam(required = false ,name="image") String image, @RequestParam(required = false,name="sypnosis") String sypnosis)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("Home");	
			return mv;
		}
		Time ti;
		if(!duration.equals(""))
		{
			duration = "00:"+duration;
			ti = Time.valueOf(duration);
		}
		else
		{
			ti=null;
		}
		duration = "00:"+duration;
		Movie max = new Movie( stage,  episodes,  reldate,  enddate, ti , rating,
				0,  movname,  image);
		max.setSypnosis(sypnosis);
		service.save(max);
		mv.setViewName("AdminDashboard");
		 return mv;
	}
	
	@GetMapping("/Movieadd")
	public  ModelAndView addMovie2(ModelAndView mv)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("Home");	
			return mv;
		}
		mv.setViewName("AddMovie");
		 return mv;
	}
}
