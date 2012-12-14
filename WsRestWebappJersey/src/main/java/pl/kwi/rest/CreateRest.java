package pl.kwi.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import com.sun.jersey.api.view.Viewable;

@Path("create")
public class CreateRest {
	
	@GET
	@Path("/")
	@Consumes
	@Produces
	public Viewable displayPage(){
		return new Viewable("/jsp/createJsp.jsp");
	}
	
	@GET
	@Path("/create-button")
	@Consumes
	@Produces
	public void createButton(@Context HttpServletResponse response) throws IOException{
		response.sendRedirect("../table");
	}
	
	@GET
	@Path("/cancel-button")
	@Consumes
	@Produces
	public void cancelButton(@Context HttpServletResponse response) throws IOException{
		response.sendRedirect("../table");
	}

}
