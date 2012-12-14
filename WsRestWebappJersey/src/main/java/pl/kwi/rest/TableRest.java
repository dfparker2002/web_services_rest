package pl.kwi.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import com.sun.jersey.api.view.Viewable;

@Path("table")
public class TableRest {
	
	@GET
	@Path("/")
	@Consumes
	@Produces
	public Viewable displayPage(){
		return new Viewable("/jsp/tableJsp.jsp");
	}
	
	@GET
	@Path("/create-button")
	@Consumes
	@Produces
	public void createButton(@Context HttpServletResponse response) throws IOException{
		response.sendRedirect("../create");
	}
	
	@GET
	@Path("/view-link/{id}")
	@Consumes
	@Produces
	public void viewLink(@Context HttpServletResponse response, @PathParam("id")Long id) throws IOException{
		response.sendRedirect("../../view/" + String.valueOf(id));
	}
	
	@GET
	@Path("/edit-link/{id}")
	@Consumes
	@Produces
	public void editLink(@Context HttpServletResponse response, @PathParam("id")Long id) throws IOException{
		response.sendRedirect("../../edit/" + String.valueOf(id));
	}
	
	@GET
	@Path("/delete-link/{id}")
	@Consumes
	@Produces
	public void deleteLink(@Context HttpServletResponse response, @PathParam("id")Long id) throws IOException{
		response.sendRedirect("../../delete/" + String.valueOf(id));
	}

}
