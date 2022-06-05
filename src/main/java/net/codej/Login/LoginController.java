package net.codej.Login;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.codej.Transfer;
import net.codej.User.User;
import net.codej.User.UserService;
import net.codej.User_Login.User_Login;
import net.codej.User_Login.User_LoginService;

@RestController
public class LoginController {
	@Autowired
	private LoginService login_service;
	@Autowired
	private UserService user_service;
	@Autowired
	private User_LoginService user_login_service;
	@PostMapping("/RegistrationDone")
	public  ModelAndView profileUser( ModelAndView mv,@RequestParam(name="username") String username,
			@RequestParam(name="email") String email, @RequestParam(name="password") String password, 
			@RequestParam(name="fname") String fname, @RequestParam(name="lname") String lname)
	{
		
		 long millis=System.currentTimeMillis();  
	     java.sql.Date date=new java.sql.Date(millis);  
		
		Login log = new Login(username,email,password);
		User user= new User(fname,lname,date,"user");
		log =login_service.save(log);
		user =user_service.save(user);
		User_Login user_login= new User_Login(log.getLogin_id(),user,log);
		user_login_service.save(user_login);          
		mv.setViewName("RegistrationDone");
		 return mv;
	}
	
	@GetMapping("/Login")
	public  ModelAndView profileUser(ModelAndView mv,
			@RequestParam(name="email") String email,
			@RequestParam(name="password") String password)
	{
		Login log =login_service.findByEmail(email);
		if(log==null)
		{
			mv.setViewName("LoginFailed");	
		}
		else if(log.getPassword().equals(password))         
		{
			
			Transfer.setLogin(log);
			if(log.getLogin_id()==100)
			{
				Transfer.setId(100);
				mv.setViewName("AdminDashboard");
				return mv;
			}
			User_Login user_login =user_login_service.findUser(log.getLogin_id());
			User u = user_login.getUser();
			Transfer.setUser(u);
			Transfer.setId(u.getUser_id());
			if(u.getState().equals("user"))
			mv.setViewName("UserDashboard");
			if(u.getState().equals("deleted"))
			mv.setViewName("Deleted");
			
		}
		else
		mv.setViewName("LoginFailed");	
		 return mv;
	}
	
	@GetMapping("/Logout")
	public  ModelAndView profileUser(ModelAndView mv)
	{
			Transfer.setLogin(null);
			Transfer.setUser(null);
			Transfer.setId(0);
		mv.setViewName("LogoutSuccesfully");	
		 return mv;
	}
	
	
}
