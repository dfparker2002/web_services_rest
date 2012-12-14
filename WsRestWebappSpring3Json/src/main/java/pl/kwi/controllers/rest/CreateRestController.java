package pl.kwi.controllers.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import pl.kwi.commands.CreateCommand;
import pl.kwi.commands.EditCommand;

@Controller
@RequestMapping("/create")
public class CreateRestController {
	
	
	@RequestMapping("/")
	public ModelAndView displayPage(
			@ModelAttribute("command") CreateCommand command,
			HttpServletRequest request, 
			HttpServletResponse response){
		
		return new ModelAndView("createJsp");
		
	}
	
	@RequestMapping(value="/create-button")
	public ModelAndView handleCreateButton(
			@ModelAttribute("command") CreateCommand command,
			HttpServletRequest request, 
			HttpServletResponse response){
				
		return new ModelAndView(new RedirectView("/table/", true, true, true));
		
	}
	
	@RequestMapping(value="/cancel-button")
	public ModelAndView handleCancelButton(
			@ModelAttribute("command")EditCommand command,
			HttpServletRequest request, 
			HttpServletResponse response){
		
		return new ModelAndView(new RedirectView("/table/", true, true, true));
		
	}


}
