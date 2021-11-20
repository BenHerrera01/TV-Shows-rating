package cl.desafiolatam.sistemaimdb.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.desafiolatam.sistemaimdb.model.Rating;
import cl.desafiolatam.sistemaimdb.model.Show;
import cl.desafiolatam.sistemaimdb.service.RatingService;
import cl.desafiolatam.sistemaimdb.service.ShowService;
import cl.desafiolatam.sistemaimdb.service.UserService;

@Controller
public class ShowController {
	
	@Autowired
	private ShowService showService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RatingService ratingService;
	
	@GetMapping({"/home","/"})
	public ModelAndView home(Principal principal) {
		ModelAndView model = new ModelAndView("home");
		model.addObject("email", principal.getName());
		model.addObject("shows", showService.findAll());

		return model;
	}
	
	@GetMapping("/showForm")
	public String showForm(Model model) {
		return "new";
	}
	
	@PostMapping("/new")
	public ModelAndView addShow(@Valid @ModelAttribute Show show, BindingResult bindingResult, Principal principal, RedirectAttributes rm) {
		if(bindingResult.hasErrors()) {
			rm.addFlashAttribute("mensaje", "Check the length of the fields");
			return new ModelAndView("redirect:/showForm");
		}
		show.setUser(userService.findByEmail(principal.getName()));
		showService.addShow(show);
		return new ModelAndView("redirect:/home");
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editShowForm(Model model, @PathVariable Long id, Principal principal) {
		Show show = new Show();
		show = showService.findById(id);
		
		if(show != null) {
			if(!show.getUser().getEmail().equals(principal.getName())) {
				return new ModelAndView("redirect:/home");
			}
			model.addAttribute("show", show);
			return new ModelAndView("edit");
		}
		return new ModelAndView("redirect:/home");
	}
	
	@PostMapping("/edit")
	public ModelAndView editShow(@Valid @ModelAttribute Show show, BindingResult bindingResult, Principal principal, RedirectAttributes rm) {
		if(bindingResult.hasErrors()) {
			rm.addFlashAttribute("mensaje", "Check the length of the fields");
			return new ModelAndView("redirect:/edit/"+show.getId());
		}
		show.setUser(userService.findByEmail(principal.getName()));
		showService.editShow(show);
		return new ModelAndView("redirect:/home");
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteShow(Model model, @RequestParam Long id) {
		Show show = new Show();
		show = showService.findById(id);
		if(show != null) {
			showService.deleteShow(show);
		}
		return new ModelAndView("redirect:/home");
	}
	
	@GetMapping("/show/{id}")
	public ModelAndView showRatings(Model model, @PathVariable Long id, Principal principal) {
		Show show = showService.findById(id);
		
		if(show != null) {
			List<Rating> showRate = new ArrayList<Rating>();
			List<Rating> ratings = ratingService.findAll();
			for (Rating userRate : ratings) {
				if(userRate.getShows().contains(showService.findById(id))) {
						showRate.add(userRate);
				}	
			}

			model.addAttribute("showRate", showRate);
			model.addAttribute("show", show);
			model.addAttribute("principalName", principal.getName());
			return new ModelAndView("show");
		}
				
		
		return new ModelAndView("redirect:/home");
	}
	

	@PostMapping("showRate")
	public ModelAndView rateShow(@Valid @ModelAttribute Rating rating, BindingResult bindingResult, Principal principal, @RequestParam("valor") String valor, RedirectAttributes rm) {
		rating.setUser(userService.findByEmail(principal.getName()));
		if(bindingResult.hasErrors()) {
			rm.addFlashAttribute("mensaje", "The rating must be between 1 - 5");
			return new ModelAndView("redirect:/show/"+valor);
		}
		
			
		if(rating.getShows() == null) {
			rating.setShows(new ArrayList<Show>());
		}
		Long idShow = Long.parseLong(valor);
		rating.getShows().add(showService.findById(idShow));

		List<Rating> ratings = ratingService.findAll();
		for (Rating userRate : ratings) {
			if (userRate.getUser().getEmail().equals(principal.getName()) && userRate.getShows().contains(showService.findById(idShow))) {
				Long id = userRate.getId();
				rating.setId(id);
			}
		}	
		ratingService.addRate(rating);
		return new ModelAndView("redirect:/show/ "+valor);
	}
	
}
