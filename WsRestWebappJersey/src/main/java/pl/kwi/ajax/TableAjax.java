package pl.kwi.ajax;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pl.kwi.entities.UserEntity;
import pl.kwi.services.UserService;

@Path("ajax/table")
public class TableAjax {
	
	private UserService userService;
	
	public TableAjax(){
		userService = new UserService();
	}
	
	@GET
	@Path("/")
	@Consumes
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers(){
		
		List<UserEntity> userList = userService.getUserList();		
		return Response.status(200).entity(userList).build();
		
	}

}
