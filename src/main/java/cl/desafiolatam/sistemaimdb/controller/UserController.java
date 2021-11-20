package cl.desafiolatam.sistemaimdb.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.desafiolatam.sistemaimdb.model.Users;
import cl.desafiolatam.sistemaimdb.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}
	
	@PostMapping("/registration")
	public ModelAndView registrarUser(@Valid @ModelAttribute Users user, BindingResult bindingResult, RedirectAttributes rm) {
		if(user!=null) {
			if(bindingResult.hasErrors()) {
				rm.addFlashAttribute("mensaje", "Wrong email format");
				return new ModelAndView("redirect:/registration");
			}
			
			if(userService.userExists(user)) {
				rm.addFlashAttribute("mensaje", "Username or email already registered");
				return new ModelAndView("redirect:/registration");
			}
			
			if (user.getPassword().equals(user.getPasswordConfirmation())) {
				userService.addUser(user);
				return new ModelAndView("login");
			} else {
				rm.addFlashAttribute("mensaje", "Passwords do not match!");
				return new ModelAndView("redirect:/registration");
			}
		}
		return new ModelAndView("redirect:/registration");
	}
}
