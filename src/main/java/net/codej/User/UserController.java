package net.codej.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.codej.Transfer;
import net.codej.Login.Login;
import net.codej.Login.LoginService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	@Autowired
	private LoginService log;
	@GetMapping("/ProfileDisplay")
	public  ModelAndView profileUser(ModelAndView mv)
	{
		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		mv.addObject("user", service.findUser(Transfer.getId()));            
		mv.setViewName("UserDisplay");
		 return mv;
	}
	
	@GetMapping("/UserDisplay")
	public  ModelAndView displayUser(ModelAndView mv, @RequestParam(name="username") String username)
	{
		

		if(Transfer.getId()==0)
		{
			mv.setViewName("login");	
			return mv;
		}
		Login l = log.findByUsername(username);
		
		if(l==null)
			mv.setViewName("RelatedNotFound");	
		else
		{
			User u =l.getUser_login().getUser();
			mv.addObject("user", u);            
			mv.setViewName("UserDisplay");
		}
		
		 return mv;
	}
	


	


}