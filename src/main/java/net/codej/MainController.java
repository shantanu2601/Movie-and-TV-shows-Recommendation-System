package net.codej;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class MainController {

		@GetMapping("/Home")
		public ModelAndView login(ModelAndView mv) {
			mv.setViewName("login");
			return mv;
		};
		
		@GetMapping("/UserDashboard")
		public ModelAndView UDashboard(ModelAndView mv) {
			mv.setViewName("UserDashboard");
			return mv;
		};
		@GetMapping("/AdminDashboard")
		public ModelAndView ADashboard(ModelAndView mv) {
			mv.setViewName("AdminDashboard");
			return mv;
		};
		@GetMapping("/Search")
		public ModelAndView Search(ModelAndView mv) {
			mv.setViewName("Search");
			return mv;
		};

	
	
		/*
		 * @GetMapping("/verify") public String verify() { return "verify";
		 * 
		 * }
		 */
		
}
