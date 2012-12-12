package pl.kwi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import pl.kwi.entities.UserEntity;
import pl.kwi.entities.UsersEntity;
import pl.kwi.services.UserService;

@Controller
@RequestMapping("user")
public class RestUserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody UserEntity getUser(@PathVariable Long id){
		
		UserEntity user = userService.readUser(id);
		return user;
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody UsersEntity getUses(){
		
		List<UserEntity> userList = userService.getUserList();
		UsersEntity users = new UsersEntity();
		users.setUsers(userList);
		return users;
		
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody UserEntity createUser(@RequestBody UserEntity user){
		
		userService.createUser(user);
		return user;
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody UserEntity updateUser(@RequestBody UserEntity user){
		
		userService.updateUser(user);
		return user;
		
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable Long id){
		
		userService.deleteUser(id);
		
	}

}
