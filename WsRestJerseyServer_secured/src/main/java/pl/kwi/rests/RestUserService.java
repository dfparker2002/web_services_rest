package pl.kwi.rests;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import pl.kwi.entities.UserEntity;
import pl.kwi.entities.UsersEntity;
import pl.kwi.services.UserService;


@Path("user")
public class RestUserService {
	
	private UserService userService;
	
	public RestUserService(){
		userService = new UserService();
	}
	
	@GET
	@Path("/")
	@Consumes
	@Produces(MediaType.APPLICATION_XML)
	public Response getUsers(){
		
		List<UserEntity> userList = userService.getUserList();
		UsersEntity users = new UsersEntity();
		users.setUsers(userList);
		return Response.status(200).entity(users).build();
		
	}
	
	@GET
	@Path("{id}")
	@Consumes
	@Produces(MediaType.APPLICATION_XML)
	public Response getUser(@PathParam("id")Long id){
		
		UserEntity user = userService.readUser(id);
		return Response.status(200).entity(user).build();
		
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response createUser(JAXBElement<UserEntity> element){
		
		UserEntity user = element.getValue();
		userService.createUser(user);
		return Response.status(200).entity(user).build();
		
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updateUser(JAXBElement<UserEntity> element){
		
		UserEntity user = element.getValue();
		userService.updateUser(user);
		return Response.status(200).entity(user).build();
		
	}
	
	@DELETE
	@Path("{id}")
	@Consumes
	@Produces
	public Response deleteUser(@PathParam("id")Long id){
		
		userService.deleteUser(id);
		return Response.status(200).build();
		
	}

}
