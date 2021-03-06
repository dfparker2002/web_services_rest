package pl.kwi.ajax;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pl.kwi.entities.UserEntity;
import pl.kwi.services.UserService;

@Path("ajax/view")
public class ViewAjax {
	
	private UserService userService;
	
	public ViewAjax(){
		userService = new UserService();
	}
	
	@GET
	@Path("{id}")
	@Consumes
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(@PathParam("id")Long id){
		
		UserEntity user = userService.readUser(id);
		return Response.status(200).entity(user).build();
		
	}

}
