package pl.kwi.controllers.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import pl.kwi.entities.UserEntity;
import pl.kwi.services.UserService;

@Controller
@RequestMapping("/ajax/delete")
public class DeleteAjaxController {
	
	
	@Autowired
	private UserService userService;
		
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public @ResponseBody UserEntity getUser(@PathVariable Long id){
		
		return userService.readUser(id);
		
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable Long id){
		
		UserEntity user = userService.readUser(id);
		userService.deleteUser(user);
		
	}
	
}
