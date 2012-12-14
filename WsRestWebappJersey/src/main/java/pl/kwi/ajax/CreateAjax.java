package pl.kwi.ajax;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pl.kwi.entities.UserEntity;
import pl.kwi.services.UserService;

@Path("ajax/create")
public class CreateAjax {
	
	private UserService userService;
	
	public CreateAjax(){
		userService = new UserService();
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces
	public Response createUser(UserEntity user){
		
		userService.createUser(user);
		return Response.status(200).build();
		
	}

}
