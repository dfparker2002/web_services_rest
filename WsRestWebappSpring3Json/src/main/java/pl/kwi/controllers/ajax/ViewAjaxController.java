package pl.kwi.controllers.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.kwi.entities.UserEntity;
import pl.kwi.services.UserService;

@Controller
@RequestMapping("/ajax/view")
public class ViewAjaxController {
	
	
	@Autowired
	private UserService userService;
		
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public @ResponseBody UserEntity viewUser(@PathVariable Long id){
		
		return userService.readUser(id);
		
	}
	
}
